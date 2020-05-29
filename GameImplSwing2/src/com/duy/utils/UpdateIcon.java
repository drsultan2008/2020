package com.duy.utils;

import javax.swing.Icon;
import com.duy.entity.*;

public class UpdateIcon {
	private Icon icon;
	private Point point;
	
	public UpdateIcon(Icon icon, Point point) {
		super();
		this.icon = icon;
		this.point = point;
	}

	public Icon getIcon() {
		return icon;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}
}
