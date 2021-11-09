package com.trieu.magicbox.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.trieu.magicbox.ui.Panel.MainPanel;

public class GUI extends JFrame implements ICommon {
	private static final int H_FRAM = 450;
	public static final int W_FRAM = 400;
	public static final String TITLE = "Design Preview [MagicBox]";

	private MainPanel mainPanel;

	public GUI() {
		init();
		addEvent();
		addComp();
	}

	@Override
	public void init() {
		setTitle(TITLE);
		setSize(W_FRAM, H_FRAM);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLayout(new CardLayout());

	}

	@Override
	public void addEvent() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int rs = JOptionPane.showConfirmDialog(GUI.this, "Bạn có muốn tắt không?", "Thông báo",
						JOptionPane.YES_NO_OPTION);
				if (rs == JOptionPane.YES_OPTION) {
					dispose();
				}
			}
		});

	}

	@Override
	public void addComp() {
		mainPanel = new MainPanel();
		add(mainPanel);
	}
}
