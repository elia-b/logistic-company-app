package application.utils;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GridBagLayoutUtils {

	public static GridBagConstraints constraint(int x, int y, int inset) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = x;
		c.gridy = y;
		//Specifies the component's external padding, the minimum amount of space between the component and the edges of its display area.
		c.insets = new Insets(inset, inset, inset, inset);
		return c;
	}
}
