package com.trieu.magicbox.ui.Panel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.trieu.magicbox.ui.ICommon;

public abstract class BasePanel extends JPanel implements ICommon, ActionListener {
	public BasePanel() {
		init();
		addEvent();
		addComp();
	}

	protected JLabel createJLabel(String text, int x, int y, Font f, Color c) {
		JLabel lb = new JLabel(text);
		lb.setFont(f);
		FontMetrics fontMetrics = getFontMetrics(lb.getFont());
		int wLB = fontMetrics.stringWidth(lb.getText());
		int hLB = fontMetrics.getHeight();
		lb.setSize(wLB, hLB);
		lb.setLocation(x, y);
		lb.setForeground(c);
		return lb;
	}

	protected JButton createJbButton(String text, String name, int x, int y, Font f, Color c) {
		JButton bt = new JButton(text);
		bt.setFont(f);
		FontMetrics fontMetrics = getFontMetrics(bt.getFont());
		int wLB = bt.getInsets().left * 2 + fontMetrics.stringWidth(bt.getText()) + 50;
		int hLB = bt.getInsets().top * 2 + fontMetrics.getHeight() + 10;
		bt.setSize(wLB, hLB);
		bt.setLocation(x, y);
		bt.setForeground(c);
		bt.setBackground(Color.LIGHT_GRAY);
		bt.setName(name);
		bt.addActionListener(this);
		return bt;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Component c = (Component) e.getSource();
		String name = c.getName();
		doClick(name);
//		JComponent comp = (JComponent) e.getSource();
//		doClick(comp.getName());

	}

	protected void doClick(String name) {

	}

}
