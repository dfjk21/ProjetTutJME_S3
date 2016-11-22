package view;

/**
 * Created by charly on 18/11/16.
 */

import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.input.ChaseCamera;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.InputListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.CameraNode;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.CameraControl;
import com.jme3.scene.shape.Box;
import com.jme3.terrain.geomipmap.TerrainLodControl;
import com.jme3.terrain.geomipmap.TerrainQuad;
import com.jme3.terrain.heightmap.AbstractHeightMap;
import com.jme3.terrain.heightmap.ImageBasedHeightMap;
import com.jme3.texture.Texture;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JME extends SimpleApplication implements ActionListener, InputListener {

    private Spatial sceneModel;
    private BulletAppState bulletAppState; //accés à la physique
    private RigidBodyControl map; //rend la carte rigide
    private CharacterControl player;
    private Vector3f walkDirection = new Vector3f();
    private Vector3f viewDirection = new Vector3f();
    private boolean isRunning = true;
    private boolean left = false, right = false, forward = false, back = false, leftCam = false, rightCam = false, up = false, down = false;
    private TerrainQuad terrain;
    Material mat_terrain;

    private Vector3f camDir = new Vector3f();
    private Vector3f camLeft = new Vector3f();

    public static void main(String[] args){
        JME app = new JME();
        app.start();
    }

    @Override
    public void simpleInitApp(){
        bulletAppState = new BulletAppState();
        stateManager.attach(bulletAppState);

        viewPort.setBackgroundColor(new ColorRGBA(0.7f,0.8f,1f,1f));
        flyCam.setMoveSpeed(100);
        setUpKeys();
        initKeys();
        setUpLight();

        mat_terrain = new Material(assetManager,
                "Common/MatDefs/Terrain/Terrain.j3md");

        mat_terrain.setTexture("Alpha", assetManager.loadTexture(
                "Textures/Terrain/splat/alphamap.png"));

        Texture grass = assetManager.loadTexture(
                "Textures/Terrain/splat/grass.jpg");
        grass.setWrap(Texture.WrapMode.Repeat);
        mat_terrain.setTexture("Tex1", grass);
        mat_terrain.setFloat("Tex1Scale", 64f);

        Texture dirt = assetManager.loadTexture(
                "Textures/Terrain/splat/dirt.jpg");
        dirt.setWrap(Texture.WrapMode.Repeat);
        mat_terrain.setTexture("Tex2", dirt);
        mat_terrain.setFloat("Tex2Scale", 32f);

        Texture rock = assetManager.loadTexture(
                "Textures/Terrain/splat/road.jpg");
        rock.setWrap(Texture.WrapMode.Repeat);
        mat_terrain.setTexture("Tex3", rock);
        mat_terrain.setFloat("Tex3Scale", 128f);

        AbstractHeightMap heightmap = null;
        Texture heightMapImage = assetManager.loadTexture(
                "Textures/Terrain/splat/mountains512.png");
        heightmap = new ImageBasedHeightMap(heightMapImage.getImage());
        heightmap.load();

        /** 3. We have prepared material and heightmap.
         * Now we create the actual terrain:
         * 3.1) Create a TerrainQuad and name it "my terrain".
         * 3.2) A good value for terrain tiles is 64x64 -- so we supply 64+1=65.
         * 3.3) We prepared a heightmap of size 512x512 -- so we supply 512+1=513.
         * 3.4) As LOD step scale we supply Vector3f(1,1,1).
         * 3.5) We supply the prepared heightmap itself.
         */
        int patchSize = 65;
        terrain = new TerrainQuad("my terrain", patchSize, 513, heightmap.getHeightMap());

        terrain.setMaterial(mat_terrain);
        terrain.setLocalTranslation(476.5f, -7.65f, 0);
        terrain.setLocalScale(2f, 1f, 2f);
        rootNode.attachChild(terrain);

        TerrainLodControl control = new TerrainLodControl(terrain, getCamera());
        terrain.addControl(control);

        sceneModel = terrain;

        CollisionShape sceneShape = CollisionShapeFactory.createMeshShape((Node) sceneModel);
        map = new RigidBodyControl(sceneShape, 0);
        sceneModel.addControl(map);

        CapsuleCollisionShape capsuleShape = new CapsuleCollisionShape(1.5f, 6f, 1);

        player = new CharacterControl(capsuleShape, 0.05f);
        player.setJumpSpeed(20);
        player.setFallSpeed(speed*30);
        player.setGravity(30);
        player.setPhysicsLocation(new Vector3f(0, 10, 0));

        rootNode.attachChild(sceneModel);
        bulletAppState.getPhysicsSpace().add(map);
        bulletAppState.getPhysicsSpace().add(player);
    }

    private void setUpLight() {
        AmbientLight al = new AmbientLight();
        al.setColor(ColorRGBA.White.mult(1.3f));
        rootNode.addLight(al);

        DirectionalLight dl = new DirectionalLight();
        dl.setColor(ColorRGBA.White);
        dl.setDirection(new Vector3f(2.8f, -2.8f, -2.8f).normalizeLocal());
        rootNode.addLight(dl);
    }

    private void setUpKeys() {
        inputManager.addMapping("leftCam", new KeyTrigger(KeyInput.KEY_LEFT));
        inputManager.addMapping("rightCam", new KeyTrigger(KeyInput.KEY_RIGHT));
        inputManager.addMapping("Up", new KeyTrigger(KeyInput.KEY_UP));
        inputManager.addMapping("Down", new KeyTrigger(KeyInput.KEY_DOWN));
        inputManager.addListener(this, "leftCam");
        inputManager.addListener(this, "rightCam");
        inputManager.addListener(this, "Up");
        inputManager.addListener(this, "Down");
    }

    private void initKeys(){
        inputManager.addMapping("Pause", new KeyTrigger(KeyInput.KEY_P));
        inputManager.addMapping("Left", new KeyTrigger(KeyInput.KEY_Q));
        inputManager.addMapping("Right", new KeyTrigger(KeyInput.KEY_D));
        inputManager.addMapping("Forward", new KeyTrigger(KeyInput.KEY_Z));
        inputManager.addMapping("Back", new KeyTrigger(KeyInput.KEY_S));
        inputManager.addMapping("Jump", new KeyTrigger(KeyInput.KEY_SPACE));
        inputManager.addListener(actionListener, new String[]{"Pause"});
        inputManager.addListener(analogListener, new String[]{"Forward", "Back", "Left", "Right", "Jump"});
    }

    public void onAction(String binding, boolean isPressed, float tpf){
        if(binding.equals("leftCam")){
            leftCam = isPressed;
        }
        else if(binding.equals("rightCam")){
            rightCam = isPressed;
        }
        else if(binding.equals("Forward")){
            up = isPressed;
        }
        else if(binding.equals("Back")){
            down = isPressed;
        }
    }

    /* This is the update loop */
    @Override
    public void simpleUpdate(float tpf) {
        camDir.set(cam.getDirection()).multLocal(0.6f);
        camLeft.set(cam.getLeft()).multLocal(0.4f);
        viewDirection.set(camDir);
        walkDirection.set(0, 0, 0);

        if(left){
            walkDirection.addLocal(camLeft);
        }
        if(right){
            walkDirection.addLocal(camLeft.negate());
        }
        if(forward){
            walkDirection.addLocal(camDir);
        }
        if(back){
            walkDirection.addLocal(camDir.negate());
        }
        player.setWalkDirection(walkDirection);
        player.setViewDirection(viewDirection);
        cam.setLocation(player.getPhysicsLocation());
    }

    private com.jme3.input.controls.ActionListener actionListener = new com.jme3.input.controls.ActionListener() {
        public void onAction(String name, boolean keyPressed, float tpf) {
            if (name.equals("Pause") && !keyPressed) {
                isRunning = !isRunning;
            }
        }
    };

    private AnalogListener analogListener = new AnalogListener() {
        public void onAnalog(String name, float value, float tpf) {
            value = 0.4f;
            if (isRunning) {
                if(name.equals("Forward")){
                    Vector3f v = player.getPhysicsLocation();
                    player.setPhysicsLocation(new Vector3f(v.x, v.y, v.z - value*speed));
                }
                if(name.equals("Back")){
                    Vector3f v = player.getPhysicsLocation();
                    player.setPhysicsLocation(new Vector3f(v.x, v.y, v.z + value*speed));
                }
                if (name.equals("Right")) {
                    Vector3f v = player.getPhysicsLocation();
                    player.setPhysicsLocation(new Vector3f(v.x + value*speed, v.y, v.z));
                }
                if (name.equals("Left")) {
                    Vector3f v = player.getPhysicsLocation();
                    player.setPhysicsLocation(new Vector3f(v.x - value*speed, v.y, v.z));
                }
                if (name.equals("Up")){
                    Vector3f v = player.getPhysicsLocation();
                    player.setPhysicsLocation(new Vector3f(v.x, v.y + value*speed, v.z));
                }
                if (name.equals("Down")){
                    Vector3f v = player.getPhysicsLocation();
                    player.setPhysicsLocation(new Vector3f(v.x, v.y - value*speed, v.z));
                }
                if(name.equals("Jump")){
                    player.jump();
                }
            } else {
                System.out.println("Press P to unpause.");
            }
        }
    };

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}

