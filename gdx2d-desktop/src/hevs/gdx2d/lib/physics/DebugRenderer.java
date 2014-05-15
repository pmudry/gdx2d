package hevs.gdx2d.lib.physics;

import hevs.gdx2d.components.physics.utils.PhysicsConstants;
import hevs.gdx2d.lib.Game2D;
import hevs.gdx2d.lib.utils.Utils;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

/**
 * A renderer that already includes scaling (because the physics world is in
 * meters and we work in pixels)
 * 
 * @author Pierre-André Mudry (mui)
 * @version 1.0.1
 */
public class DebugRenderer extends Box2DDebugRenderer {
	@Override
	public void render(World world, Matrix4 projMatrix) {
		// "Gdx.gl10" must be not null for the ShapeRenderer used by
		// Box2DDebugRenderer
		Utils.assertGdxLoaded("The DebugRenderer can only be created in the onInit "
				+ "method of a class extending PortableApplication "
				+ "(or must be called from within this method)");

		Game2D.g.resetRenderingMode();
		Matrix4 debugM = projMatrix.cpy().scale(
				PhysicsConstants.METERS_TO_PIXELS,
				PhysicsConstants.METERS_TO_PIXELS, 1);
		super.render(world, debugM);
	}
}
