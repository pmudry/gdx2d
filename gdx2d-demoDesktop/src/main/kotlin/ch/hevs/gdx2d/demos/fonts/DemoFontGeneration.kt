package ch.hevs.gdx2d.demos.fonts

import ch.hevs.gdx2d.desktop.PortableApplication
import ch.hevs.gdx2d.lib.GdxGraphics
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.files.FileHandle
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter
import com.badlogic.gdx.utils.Align

/**
 * A demo that shows how to generate different fonts and hot to display texts with different alignments. Custom font
 * (ttf files) can be loaded from the resource folder and customized using parameters of the
 * `FreeTypeFontParameter` class.
 *
 * @author Pierre-André Mudry (mui)
 * @author Christopher Métrailler (mei)
 * @version 1.2
 */
class DemoFontGeneration : PortableApplication() {
    private lateinit var optimus60: BitmapFont
    private lateinit var optimus40: BitmapFont
    private lateinit var timeless40: BitmapFont
    private lateinit var starjedi40: BitmapFont
    private lateinit var icepixel40: BitmapFont

    override fun onInit() {
        this.setTitle("Font generation demo, mui 2013")

        // Load some font files
        val optimusF = Gdx.files.internal("font/OptimusPrinceps.ttf")
        val timelessF = Gdx.files.internal("font/Timeless.ttf")
        val starjediF = Gdx.files.internal("font/Starjedi.ttf")
        val icePixelF = Gdx.files.internal("font/ice_pixel-7.ttf")

        // See all parameters available in the FreeTypeFontParameter
        val parameter = FreeTypeFontParameter()

        /**
         * Generates the fonts images from the TTF file
         */
        var generator = FreeTypeFontGenerator(optimusF)
        parameter.size = generator.scaleForPixelHeight(40)
        parameter.color = Color.WHITE
        optimus40 = generator.generateFont(parameter)

        parameter.size = generator.scaleForPixelHeight(60)
        parameter.color = Color.BLUE
        optimus60 = generator.generateFont(parameter)
        generator.dispose()

        generator = FreeTypeFontGenerator(timelessF)
        parameter.size = generator.scaleForPixelHeight(40)
        parameter.color = Color.RED
        timeless40 = generator.generateFont(parameter)
        generator.dispose()

        generator = FreeTypeFontGenerator(starjediF)
        parameter.size = generator.scaleForPixelHeight(40)
        parameter.color = Color.GREEN
        starjedi40 = generator.generateFont(parameter)
        generator.dispose()

        // Use shadows, border, etc.
        generator = FreeTypeFontGenerator(icePixelF)
        parameter.size = generator.scaleForPixelHeight(40)
        parameter.color = Color.WHITE
        parameter.borderColor = Color.BLUE
        parameter.borderWidth = 3f
        parameter.shadowOffsetY = -8
        parameter.shadowColor = Color.LIGHT_GRAY
        icepixel40 = generator.generateFont(parameter)
        generator.dispose()
    }

    override fun onGraphicRender(g: GdxGraphics) {
        val h = g.screenHeight.toFloat()
        val y = h / 7.0f
        val w = g.screenWidth.toFloat()

        g.clear()

        // Use the default font Robot 15
        g.setColor(Color.WHITE)
        g.drawStringCentered(y / 2 + y * 1, LOREM)

        // Display different fonts centered (X axis) on the screen
        g.drawStringCentered(y / 2 + y * 6, "Ice pixel 40", icepixel40)
        g.drawStringCentered(y / 2 + y * 4, "Timeless size 40", timeless40)
        g.drawStringCentered(y / 2 + y * 3, "Optimus size 40", optimus40)
        g.drawStringCentered(y / 2 + y * 2, "Optimus size 60", optimus60)

        // Display fonts with rotation
        g.drawStringRotated(w / 2 - 50, y / 2 + y * 4.8f, "Hello", starjedi40, 20f)
        g.drawStringRotated(w / 2 + 50, y / 2 + y * 4.8f, "World", starjedi40, -20f)

        // Display fonts with left, right and center alignment
        g.setColor(Color.MAGENTA)
        g.drawString(10f, h - 10, "left\naligned\ntext", Align.left)
        g.drawString(w - 10, h - 10, "right\naligned\ntext", Align.right)
    }

    override fun onDispose() {
        // Release what we've used
        super.onDispose()
        optimus40.dispose()
        optimus60.dispose()
        timeless40.dispose()
        starjedi40.dispose()
        icepixel40.dispose()
    }
}

private val LOREM = ("Lorem ipsum dolor sit amet,\n" + "consectetur adipiscing elit.\n"
  + "In laoreet libero sit amet\n" + "sollicitudin vestibulum.\n" + "The default font is Roboto size 15, white")

fun main(args: Array<String>) {
  DemoFontGeneration()
}
