package com.trieu.magicbox.ui.Panel;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.trieu.magicbox.ui.GUI;

public class MagicBoxPanel extends BasePanel implements Runnable {
	private static final String BT_1 = "BT_1";
	private static final String BT_2 = "BT_2";
	private static final String BT_3 = "BT_3";
	private static final String BT_4 = "BT_4";
	private static final String BT_5 = "BT_5";
	private static final String BT_6 = "BT_6";
	private static final String BT_7 = "BT_7";
	private static final String BT_8 = "BT_8";
	private static final String BT_9 = "BT_9";
	private JButton bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, btTong;
	private JLabel lbTitle, lbTime, lbDem;
	private Thread th;
	private Random random;
	private int tong;

	@Override
	public void init() {
		setBackground(Color.WHITE);
		setLayout(null);

	}

	@Override
	public void addEvent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addComp() {

		Font fBig = new Font("Arial", Font.BOLD, 20);
		Font f = new Font("Arial", Font.BOLD, 25);

		lbTitle = createJLabel("MAGIC BOX", 0, 0, fBig, Color.RED);
		int xCenter = GUI.W_FRAM / 2 - lbTitle.getWidth() / 2;
		lbTitle.setLocation(xCenter, 20);
		add(lbTitle);

		lbTime = createJLabel("TIMES: ", 0, 0, f, Color.BLUE);
		int xCen = GUI.W_FRAM / 2 - lbTime.getWidth() / 2;
		lbTime.setLocation(xCen, lbTitle.getY() + lbTitle.getHeight() + 20);
		add(lbTime);

		lbDem = createJLabel("5", lbTime.getX() + lbTime.getWidth(), lbTime.getY(), f, Color.BLUE);
		add(lbDem);

		bt1 = createJbButton("", BT_1, 60, lbTime.getY() + lbTime.getHeight() + 20, fBig, Color.BLACK);
//		bt1.setSize(lbTime.getWidth() / 2, lbTime.getHeight() + 20);
		add(bt1);
		bt2 = createJbButton("", BT_2, bt1.getX() + bt1.getWidth() + 10, bt1.getY(), fBig, Color.BLACK);
//		bt2.setSize(lbTime.getWidth() / 2, lbTime.getHeight() + 20);
		add(bt2);
		bt3 = createJbButton("", BT_3, bt2.getX() + bt2.getWidth() + 10, bt1.getY(), fBig, Color.BLACK);
//		bt3.setSize(lbTime.getWidth() / 2, lbTime.getHeight() + 20);
		add(bt3);
		bt4 = createJbButton("", BT_4, bt1.getX(), bt1.getY() + bt1.getHeight() + 10, fBig, Color.BLACK);
//		bt4.setSize(lbTime.getWidth() / 2, lbTime.getHeight() + 20);
		add(bt4);
		bt5 = createJbButton("", BT_5, bt2.getX(), bt4.getY(), fBig, Color.BLACK);
//		bt5.setSize(lbTime.getWidth() / 2, lbTime.getHeight() + 20);
		add(bt5);
		bt6 = createJbButton("", BT_6, bt3.getX(), bt4.getY(), fBig, Color.BLACK);
//		bt6.setSize(lbTime.getWidth() / 2, lbTime.getHeight() + 20);
		add(bt6);
		bt7 = createJbButton("", BT_7, bt4.getX(), bt4.getY() + bt4.getHeight() + 10, fBig, Color.BLACK);
//		bt7.setSize(lbTime.getWidth() / 2, lbTime.getHeight() + 20);
		add(bt7);
		bt8 = createJbButton("", BT_8, bt5.getX(), bt7.getY(), fBig, Color.BLACK);
//		bt8.setSize(lbTime.getWidth() / 2, lbTime.getHeight() + 20);
		add(bt8);
		bt9 = createJbButton("", BT_9, bt3.getX(), bt7.getY(), fBig, Color.BLACK);
//		bt9.setSize(lbTime.getWidth() / 2, lbTime.getHeight() + 20);
		add(bt9);

		btTong = createJbButton("", "", lbTime.getX() + 20, bt9.getY() + bt9.getHeight() + 10, f, Color.BLACK);
		btTong.setSize(70, 70);
		add(btTong);

	}

	@Override
	protected void doClick(String name) {
		int countDown = Integer.parseInt(lbDem.getText());
		if (countDown <= 0 || tong == 30) {
			return;
		} else if (th == null) {
			th = new Thread(this);
			th.setDaemon(true);
			th.start();
		}
		switch (name) {
		case BT_1:
			bt1.setText(randomNB());
			break;
		case BT_2:
			bt2.setText(randomNB());
			break;
		case BT_3:
			bt3.setText(randomNB());
			break;
		case BT_4:
			bt4.setText(randomNB());
			break;
		case BT_5:
			bt5.setText(randomNB());
			break;
		case BT_6:
			bt6.setText(randomNB());
			break;
		case BT_7:
			bt7.setText(randomNB());
			break;
		case BT_8:
			bt8.setText(randomNB());
			break;
		case BT_9:
			bt9.setText(randomNB());
			break;

		default:
			break;
		}
		th = null;
	}

	public String randomNB() {
		int kq = 0;
		random = new Random();
		kq = random.nextInt(11);
		tong += kq;
		return kq + "";
	}

	@Override
	public void run() {
		int i = Integer.parseInt(lbDem.getText());
		i--;
		lbDem.setText(i + "");
		btTong.setText(tong + "");
		if (tong >= 30) {
			JOptionPane.showMessageDialog(null, "YOU WIN");
		} else if (i == 0 && tong < 30) {
			JOptionPane.showMessageDialog(null, "YOU LOSE");
		}
	}

}
