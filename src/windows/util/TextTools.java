package windows.util;

import java.awt.Font;
import java.awt.FontMetrics;
 
/**
 * Created by Kyle at Aug 17, 2014
 */
public class TextTools {
	public static int findXCenter(String string, Font f, FontMetrics fm, int w) {
        return ((w - fm.stringWidth(string)) / 2);
	}
	
	public static int findYCenter(String string, Font f, FontMetrics fm, int h) {
        return ((h - fm.getHeight()) / 2) + fm.getAscent();
	}
}
