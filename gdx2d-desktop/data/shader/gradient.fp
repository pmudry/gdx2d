// A simple gradient that spans the entire shader
// Pierre-André Mudry, 2014

// What we get from Java, *once*
uniform vec2 center;
uniform vec2 resolution;

/**
 * Received from vertex shader
 */
in vec4 v_color; // The interpolated color of each fragment before transform

/**
 * Produced by the fragment shader
 */
out vec4 o_fragColor; // Each fragment color

void main() {
	// position of the fragment, normalized to [0..1]
	vec2 position = ( gl_FragCoord.xy / resolution.xy );
	
	// the color of the fragment depends on its position, linearly  
	o_fragColor = vec4(0, 0, position.y, 1.0);
}
