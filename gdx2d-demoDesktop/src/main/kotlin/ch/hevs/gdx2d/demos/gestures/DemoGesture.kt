package ch.hevs.gdx2d.demos.gestures

import ch.hevs.gdx2d.components.bitmaps.BitmapImage
import ch.hevs.gdx2d.desktop.PortableApplication
import ch.hevs.gdx2d.lib.GdxGraphics
import ch.hevs.gdx2d.lib.utils.Logger
import com.badlogic.gdx.graphics.OrthographicCamera

/**
 * Simple demo for gestures on Android.
 *
 * @author Pierre-André Mudry (mui)
 * @version 1.01
 */
class DemoGesture : PortableApplication() {

    lateinit var image: BitmapImage

    var cam: OrthographicCamera? = null
    var initialScale = 1.0f

    init {
        if (!onAndroid()) {
            Logger.error("This demo only works on Android! Exiting")
            exit()
        }
    }

    override fun onZoom(initialDistance: Float, distance: Float) {
        val ratio = initialDistance / distance
        cam!!.zoom = initialScale * ratio
        cam!!.update()
    }

    override fun onClick(x: Int, y: Int, button: Int) {
        initialScale = cam!!.zoom
    }

    override fun onPan(x: Float, y: Float, deltaX: Float, deltaY: Float) {
        cam!!.position.add(-deltaX * cam!!.zoom, deltaY * cam!!.zoom, 0f)
        cam!!.update()
    }

    override fun onInit() {
        image = BitmapImage("images/Android_PI_48x48.png")
    }

    override fun onGraphicRender(g: GdxGraphics) {
        g.clear()

        if (cam == null)
            cam = g.camera

        g.drawPicture((windowWidth / 2).toFloat(), (windowHeight / 2).toFloat(), image)
        g.drawSchoolLogoUpperRight()
        g.drawFPS()
    }
}


fun main(args: Array<String>) {
  DemoGesture()
}
