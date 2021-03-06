package ch.hevs.gdx2d.demos.scrolling.objects

import ch.hevs.gdx2d.components.bitmaps.BitmapImage
import ch.hevs.gdx2d.lib.GdxGraphics
import ch.hevs.gdx2d.lib.interfaces.DrawableObject

/**
 * A simple pipe that does nothing special
 *
 * @author Pierre-Andre Mudry (mui)
 */

class Pipe(var posx: Int, var posy: Int) : DrawableObject {

    val img = BitmapImage("images/pipe.png")

    override fun draw(g: GdxGraphics) {
        g.drawPicture(posx.toFloat(), posy.toFloat(), img)
    }

}
