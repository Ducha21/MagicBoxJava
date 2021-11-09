package com.trieu.magicbox.ui.Panel;

import java.awt.CardLayout;
import java.awt.Color;

public class MainPanel extends BasePanel {
	private MagicBoxPanel mBP;

	@Override
	public void init() {
		setBackground(Color.WHITE);
		setLayout(new CardLayout());

	}

	@Override
	public void addEvent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addComp() {
		mBP = new MagicBoxPanel();
		add(mBP);
	}

}
