package com.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Random;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class CheckCodeAction extends BaseAction{
	private static int WIDTH = 180;

	private static int HEIGHT = 50;

	private static int NUM = 5;

	private static char[] seq = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
			'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
			'W', 'X', 'Y', 'Z',  '2', '3', '4', '5', '6', '7', '8','9' };
	private InputStream is;
	public String execute() {
		byte[] data = randomImage();
		is = new ByteArrayInputStream(data);
		return "success";
	}

	/**
	 * 
	 * @return
	 */
	private byte[] randomImage() {
		Random r = new Random();

		// 图片的内存映�?
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);

		// 获得画笔对象
		Graphics g = image.getGraphics();
		g.setColor(randomColor(r));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(new Color(0, 0, 0));

		// 用于存储随机生成的验证码
		StringBuffer number= new StringBuffer();

		// 绘制验证�?
		for (int i = 0; i < NUM; i++) {
			g.setColor(randomColor(r));
			int h = (int) ((HEIGHT * 60 / 100) * r.nextDouble() + (HEIGHT * 30 / 100));
			g.setFont(new Font(null, Font.BOLD | Font.ITALIC, h));
			String ch = String.valueOf(seq[r.nextInt(seq.length)]);
			number.append(ch);
			g.drawString(ch, i * WIDTH / NUM * 90 / 100, h);
		}
         session.put("number", number.toString());
		// 绘制干扰�?
		for (int i = 0; i <= 12; i++) {
			g.setColor(randomColor(r));
			g.drawLine(r.nextInt(WIDTH), r.nextInt(HEIGHT), r.nextInt(WIDTH), r
					.nextInt(HEIGHT));

		}

		ByteArrayOutputStream os = new ByteArrayOutputStream();

		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);

		// 把BufferedImage对象中的图像信息编码�?
		// 向创建该对象(encoder)时指定的输出流输�?
		try {
			encoder.encode(image);
			return os.toByteArray();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private Color randomColor(Random r) {
		return new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
	}

	public InputStream getIs() {
		return is;
	}

	public void setIs(InputStream is) {
		this.is = is;
	}

}
