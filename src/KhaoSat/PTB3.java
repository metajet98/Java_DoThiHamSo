package KhaoSat;

import java.awt.Frame;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import javafx.scene.Group;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class PTB3 {
	private double _a3, _b3, _c3, _d3;// biáº¿n cá»§a Ä‘á»“ thá»‹ báº­c 3

	private String _yPhay, _y2Phay;
	private String TXD, GioiHan, DBNB, DiemUon;
	private int limit_min, limit_max;
	private double y_min, y_max;
	private String GTLN, GTNN;

	public String khaosat;
	private String cuctri;

	private double d, x1, x2, cucdai, cuctieu, xdiemuon, ydiemuon;

	public String getGTLN() {
		return GTLN;
	}

	public void setGTLN(String gTLN) {
		GTLN = gTLN;
	}

	public String getGTNN() {
		return GTNN;
	}

	public void setGTNN(String gTNN) {
		GTNN = gTNN;
	}

	public double getD() {
		return d;
	}

	public double getX1() {
		return x1;
	}

	public void setX1(double x1) {
		this.x1 = x1;
	}

	public void setD(double d) {
		this.d = d;
	}

	public double getX2() {
		return x2;
	}

	public void setX2(double x2) {
		this.x2 = x2;
	}

	public double getCucdai() {
		return cucdai;
	}

	public void setCucdai(double cucdai) {
		this.cucdai = cucdai;
	}

	public double getCuctieu() {
		return cuctieu;
	}

	public void setCuctieu(double cuctieu) {
		this.cuctieu = cuctieu;
	}

	public double getXdiemuon() {
		return xdiemuon;
	}

	public void setXdiemuon(double xdiemuon) {
		this.xdiemuon = xdiemuon;
	}

	public double getYdiemuon() {
		return ydiemuon;
	}

	public void setYdiemuon(double ydiemuon) {
		this.ydiemuon = ydiemuon;
	}

	public void NhapPT3(Double a3, Double b3, Double c3, Double d3, int lim_min, int lim_max) {
		try {
			this._a3 = a3;
			this._b3 = b3;
			this._c3 = c3;
			this._d3 = d3;
			this.limit_min = lim_min;
			this.limit_max = lim_max;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Loi nhap phuong trinh bac 3");
		}
	}

	public int getLimit_min() {
		return limit_min;
	}

	public void setLimit_min(int limit_min) {
		this.limit_min = limit_min;
	}

	public int getLimit_max() {
		return limit_max;
	}

	public void setLimit_max(int limit_max) {
		this.limit_max = limit_max;
	}

	public void VeBangBienThien(Group gr) {
		DecimalFormat dcf = new DecimalFormat("#.##");
		gr.getChildren().clear();
		// region VeKhung
		Rectangle r1 = new Rectangle(0, 0, 400, 140);
		r1.setStroke(Color.BLACK);
		r1.setFill(null);
		r1.setStrokeWidth(3);

		Line l1 = new Line(r1.getX(), r1.getY() + 20, 400, r1.getY() + 20);
		Line l2 = new Line(r1.getX(), r1.getY() + 40, 400, r1.getY() + 40);
		Line l3 = new Line(r1.getX() + 20, r1.getY(), r1.getX() + 20, r1.getHeight());

		Text text1 = new Text(r1.getX() + 5, r1.getY() + 15, "x");
		Text text2 = new Text(r1.getX() + 5, r1.getY() + 35, "y'");
		Text text3 = new Text(r1.getX() + 5, r1.getY() + 55, "y");
		// endregion

		// region VietGiaTri
		double delta = 2 * _b3 * 2 * _b3 - 4 * 3 * _a3 * _c3;
		x1 = (((-2) * _b3 + Math.sqrt(delta)) / (2 * 3 * _a3));
		x2 = (((-2) * _b3 - Math.sqrt(delta)) / (2 * 3 * _a3));
		String x31 = dcf.format(x1);
		String x32 = dcf.format(x2);
		double y31 = (_a3 * x1 * x1 * x1 + _b3 * x1 * x1 + _c3 * x1 + _d3);
		double y32 = (_a3 * x2 * x2 * x2 + _b3 * x2 * x2 + _c3 * x2 + _d3);

		String str_limit_min = String.valueOf(limit_min);
		String str_limit_max = String.valueOf(limit_max);
		double ylimit_min = (_a3 * limit_min * limit_min * limit_min + _b3 * limit_min * limit_min + _c3 * limit_min
				+ _d3);
		double ylimit_max = (_a3 * limit_max * limit_max * limit_max + _b3 * limit_max * limit_max + _c3 * limit_max
				+ _d3);
		String str_ylimit_min = String.valueOf(ylimit_min);
		String str_ylimit_max = String.valueOf(ylimit_max);

		y31 = Math.round((y31 * 100) / 100);
		y32 = Math.round((y32 * 100) / 100);
		String str_y31 = String.valueOf(y31);
		String str_y32 = String.valueOf(y32);

		if (x1 < x2) {
			if (delta > 0 && _a3 > 0) {
				// Dien gia tri len khung x
				Text t1 = new Text(r1.getX() + 35, r1.getY() + 15, "-oo");

				Text t2 = new Text(r1.getX() + 150, r1.getY() + 15, x31);

				Text t3 = new Text(r1.getX() + 250, r1.getY() + 15, x32);
				Text t4 = new Text(r1.getX() + r1.getWidth() - 35, r1.getY() + 15, "+oo");
				// Dien gia tri len khung y'
				Text t5 = new Text(r1.getX() + 75, r1.getY() + 35, "+");
				Text t6 = new Text(r1.getX() + 150, r1.getY() + 35, "0");
				Text t7 = new Text(r1.getX() + 200, r1.getY() + 35, "-");
				Text t8 = new Text(r1.getX() + 250, r1.getY() + 35, "0");
				Text t9 = new Text(r1.getX() + r1.getWidth() - 75, r1.getY() + 35, "+");

				// Dien gia tri len khung y
				Text t11 = new Text(r1.getX() + 35, r1.getY() + r1.getHeight() - 20, "-oo");
				Line line1 = new Line(r1.getX() + 75, r1.getY() + r1.getHeight() - 10, r1.getX() + 150, r1.getY() + 55);

				Text t10 = new Text(r1.getX() + 150, r1.getY() + 55, str_y31);
				Line line2 = new Line(r1.getX() + 155, r1.getY() + 55, r1.getX() + 250,
						r1.getY() + r1.getHeight() - 10);

				Text t12 = new Text(r1.getX() + 250, r1.getY() + r1.getHeight() - 20, str_y32);
				Line line3 = new Line(r1.getX() + 255, r1.getY() + r1.getHeight() - 10, r1.getX() + r1.getWidth() - 35,
						r1.getY() + 55);
				Text t13 = new Text(r1.getX() + r1.getWidth() - 35, r1.getY() + 55, "+oo");

				// them gioi han
//        		  Text text11 = new Text(r1.getX()+85,r1.getY()+15,str_limit_min);
//        		  Text text12 = new Text(r1.getX()+220,r1.getY()+15,str_limit_max);
//        		  Text text13 = new Text(r1.getX()+85,r1.getY()+75,str_ylimit_min);
//        		  Text text14 = new Text(r1.getX()+220,r1.getY()+75,str_ylimit_max);

				// gr.getChildren().addAll(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,line1,line2,line3,text11,text12,text13,text14);
				gr.getChildren().addAll(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, line1, line2, line3);
			} else {
				if (delta > 0 && _a3 < 0) {
					// Dien gia tri len khung x
					Text t1 = new Text(r1.getX() + 35, r1.getY() + 15, "-oo");
					Text t2 = new Text(r1.getX() + 150, r1.getY() + 15, x31);
					Text t3 = new Text(r1.getX() + 250, r1.getY() + 15, x32);
					Text t4 = new Text(r1.getX() + r1.getWidth() - 35, r1.getY() + 15, "+oo");
					// Dien gia tri len khung y'
					Text t5 = new Text(r1.getX() + 75, r1.getY() + 35, "-");
					Text t6 = new Text(r1.getX() + 150, r1.getY() + 35, "0");
					Text t7 = new Text(r1.getX() + 200, r1.getY() + 35, "+");
					Text t8 = new Text(r1.getX() + 250, r1.getY() + 35, "0");
					Text t9 = new Text(r1.getX() + r1.getWidth() - 75, r1.getY() + 35, "-");

					// Dien gia tri len khung y
					Text t11 = new Text(r1.getX() + 35, r1.getY() + 55, "+oo");
					Line line1 = new Line(r1.getX() + 75, r1.getY() + 55, r1.getX() + 150,
							r1.getY() + r1.getHeight() - 10);
					Text t10 = new Text(r1.getX() + 150, r1.getY() + r1.getHeight() - 20, str_y31);
					Line line2 = new Line(r1.getX() + 155, r1.getY() + r1.getHeight() - 10, r1.getX() + 250,
							r1.getY() + 55);
					Text t12 = new Text(r1.getX() + 250, r1.getY() + 55, str_y32);
					Line line3 = new Line(r1.getX() + 255, r1.getY() + 55, r1.getX() + r1.getWidth() - 35,
							r1.getY() + r1.getHeight() - 10);
					Text t13 = new Text(r1.getX() + r1.getWidth() - 35, r1.getY() + r1.getHeight() - 20, "-oo");

//        		  //them gioi han
//        		  Text text11 = new Text(r1.getX()+85,r1.getY()+15,str_limit_min);
//        		  Text text12 = new Text(r1.getX()+220,r1.getY()+15,str_limit_max);
//        		  Text text13 = new Text(r1.getX()+85,r1.getY()+75,str_ylimit_min);
//        		  Text text14 = new Text(r1.getX()+220,r1.getY()+75,str_ylimit_max);
					// gr.getChildren().addAll(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,line1,line2,line3,text11,text12,text13,text14);
					gr.getChildren().addAll(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, line1, line2,
							line3);
				} else {
					if (delta <= 0 && _a3 > 0) {
						// Dien gia tri len khung x
						Text t1 = new Text(r1.getX() + 35, r1.getY() + 15, "-oo");
						Text t2 = new Text(r1.getX() + 150, r1.getY() + 15, x31);
						Text t4 = new Text(r1.getX() + r1.getWidth() - 35, r1.getY() + 15, "+oo");
						// Dien gia tri len khung y'
						Text t5 = new Text(r1.getX() + 75, r1.getY() + 35, "+");
						Text t6 = new Text(r1.getX() + 150, r1.getY() + 35, "0");
						Text t7 = new Text(r1.getX() + 200, r1.getY() + 35, "+");
						// Dien gia tri khung y
						Line line1 = new Line(r1.getX() + 75, r1.getY() + r1.getHeight() - 10,
								r1.getX() + r1.getWidth() - 35, r1.getY() + 55);
						Text t10 = new Text(r1.getX() + 150, r1.getY() + 90, str_y31);
						Text t11 = new Text(r1.getX() + 35, r1.getY() + r1.getHeight() - 10, "-oo");
						Text t12 = new Text(r1.getX() + r1.getWidth() - 35, r1.getY() + 55, "+oo");

//                		//them gioi han
//                		  Text text11 = new Text(r1.getX()+85,r1.getY()+15,str_limit_min);
//                		  Text text12 = new Text(r1.getX()+220,r1.getY()+15,str_limit_max);
//                		  Text text13 = new Text(r1.getX()+85,r1.getY()+75,str_ylimit_min);
//                		  Text text14 = new Text(r1.getX()+220,r1.getY()+75,str_ylimit_max);

						// gr.getChildren().addAll(t1,t2,t4,t5,t6,t7,line1,t10,t11,t12,text11,text12,text13,text14);
						gr.getChildren().addAll(t1, t2, t4, t5, t6, t7, line1, t10, t11, t12);
					} else {
						// Dien gia tri len khung x
						Text t1 = new Text(r1.getX() + 35, r1.getY() + 15, "-oo");
						Text t2 = new Text(r1.getX() + 150, r1.getY() + 15, x31);
						Text t4 = new Text(r1.getX() + r1.getWidth() - 35, r1.getY() + 15, "+oo");
						// Dien gia tri len khung y'
						Text t5 = new Text(r1.getX() + 75, r1.getY() + 35, "-");
						Text t6 = new Text(r1.getX() + 150, r1.getY() + 35, "0");
						Text t7 = new Text(r1.getX() + 200, r1.getY() + 35, "-");
						// Dien gia tri khung y
						Line line1 = new Line(r1.getX() + 75, r1.getY() + 55, r1.getX() + r1.getWidth() - 35,
								r1.getY() + r1.getHeight() - 10);
						Text t10 = new Text(r1.getX() + 150, r1.getY() + 90, str_y31);
						Text t11 = new Text(r1.getX() + 35, r1.getY() + 55, "+oo");
						Text t12 = new Text(r1.getX() + r1.getWidth() - 35, r1.getY() + r1.getHeight() - 10, "-oo");

//               		//them gioi han
//               		Text text11 = new Text(r1.getX()+85,r1.getY()+15,str_limit_min);
//          		  Text text12 = new Text(r1.getX()+220,r1.getY()+15,str_limit_max);
//          		  Text text13 = new Text(r1.getX()+85,r1.getY()+75,str_ylimit_min);
//          		  Text text14 = new Text(r1.getX()+220,r1.getY()+75,str_ylimit_max);

						// gr.getChildren().addAll(t1,t2,t4,t5,t6,t7,line1,t10,t11,t12,text11,text12,text13,text14);
						gr.getChildren().addAll(t1, t2, t4, t5, t6, t7, line1, t10, t11, t12);
					}
				}
			}
		} else {
			if (delta > 0 && _a3 > 0) {
				// Dien gia tri len khung x
				Text t1 = new Text(r1.getX() + 35, r1.getY() + 15, "-oo");
				Text t2 = new Text(r1.getX() + 150, r1.getY() + 15, x32);
				Text t3 = new Text(r1.getX() + 250, r1.getY() + 15, x31);
				Text t4 = new Text(r1.getX() + r1.getWidth() - 35, r1.getY() + 15, "+oo");

				// Dien gia tri len khung y'
				Text t5 = new Text(r1.getX() + 75, r1.getY() + 35, "+");
				Text t6 = new Text(r1.getX() + 150, r1.getY() + 35, "0");
				Text t7 = new Text(r1.getX() + 200, r1.getY() + 35, "-");
				Text t8 = new Text(r1.getX() + 250, r1.getY() + 35, "0");
				Text t9 = new Text(r1.getX() + r1.getWidth() - 75, r1.getY() + 35, "+");

				Text t11 = new Text(r1.getX() + 35, r1.getY() + r1.getHeight() - 20, "-oo");
				Line line1 = new Line(r1.getX() + 75, r1.getY() + r1.getHeight() - 10, r1.getX() + 150, r1.getY() + 55);
				Text t10 = new Text(r1.getX() + 150, r1.getY() + 55, str_y32);
				Line line2 = new Line(r1.getX() + 155, r1.getY() + 55, r1.getX() + 250,
						r1.getY() + r1.getHeight() - 10);
				Text t12 = new Text(r1.getX() + 250, r1.getY() + r1.getHeight() - 20, str_y31);
				Line line3 = new Line(r1.getX() + 255, r1.getY() + r1.getHeight() - 10, r1.getX() + r1.getWidth() - 35,
						r1.getY() + 55);
				Text t13 = new Text(r1.getX() + r1.getWidth() - 35, r1.getY() + 55, "+oo");

//    		//them gioi han
//    		  Text text11 = new Text(r1.getX()+85,r1.getY()+15,str_limit_min);
//    		  Text text12 = new Text(r1.getX()+220,r1.getY()+15,str_limit_max);
//    		  Text text13 = new Text(r1.getX()+85,r1.getY()+75,str_ylimit_min);
//    		  Text text14 = new Text(r1.getX()+220,r1.getY()+75,str_ylimit_max);

				// gr.getChildren().addAll(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,line1,line2,line3,text11,text12,text13,text14);
				gr.getChildren().addAll(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, line1, line2, line3);
			} else {
				if (delta > 0 && _a3 < 0) {
					// Dien gia tri len khung x
					Text t1 = new Text(r1.getX() + 35, r1.getY() + 15, "-oo");
					Text t2 = new Text(r1.getX() + 150, r1.getY() + 15, x32);
					Text t3 = new Text(r1.getX() + 250, r1.getY() + 15, x31);
					Text t4 = new Text(r1.getX() + r1.getWidth() - 35, r1.getY() + 15, "+oo");
					// Dien gia tri len khung y'
					Text t5 = new Text(r1.getX() + 75, r1.getY() + 35, "-");
					Text t6 = new Text(r1.getX() + 150, r1.getY() + 35, "0");
					Text t7 = new Text(r1.getX() + 200, r1.getY() + 35, "+");
					Text t8 = new Text(r1.getX() + 250, r1.getY() + 35, "0");
					Text t9 = new Text(r1.getX() + r1.getWidth() - 75, r1.getY() + 35, "-");

					// Dien gia tri len khung y
					Text t11 = new Text(r1.getX() + 35, r1.getY() + r1.getHeight() - 20, "+oo");
					Line line1 = new Line(r1.getX() + 75, r1.getY() + 55, r1.getX() + 150,
							r1.getY() + r1.getHeight() - 10);
					Text t10 = new Text(r1.getX() + 150, r1.getY() + 55, str_y32);
					Line line2 = new Line(r1.getX() + 155, r1.getY() + r1.getHeight() - 10, r1.getX() + 250,
							r1.getY() + 55);
					Text t12 = new Text(r1.getX() + 250, r1.getY() + r1.getHeight() - 20, str_y31);
					Line line3 = new Line(r1.getX() + 255, r1.getY() + 55, r1.getX() + r1.getWidth() - 35,
							r1.getY() + r1.getHeight() - 10);
					Text t13 = new Text(r1.getX() + r1.getWidth() - 35, r1.getY() + 55, "-oo");

//           		//them gioi han
//           		Text text11 = new Text(r1.getX()+85,r1.getY()+15,str_limit_min);
//      		  Text text12 = new Text(r1.getX()+220,r1.getY()+15,str_limit_max);
//      		  Text text13 = new Text(r1.getX()+85,r1.getY()+75,str_ylimit_min);
//      		  Text text14 = new Text(r1.getX()+220,r1.getY()+75,str_ylimit_max);

					// gr.getChildren().addAll(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,line1,line2,line3,text11,text12,text13,text14);
					gr.getChildren().addAll(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, line1, line2,
							line3);
				} else {
					if (delta <= 0 && _a3 > 0) {
						// Dien gia tri len khung x
						Text t1 = new Text(r1.getX() + 35, r1.getY() + 15, "-oo");
						Text t2 = new Text(r1.getX() + 150, r1.getY() + 15, x31);
						Text t4 = new Text(r1.getX() + r1.getWidth() - 35, r1.getY() + 15, "+oo");
						// Dien gia tri len khung y'
						Text t5 = new Text(r1.getX() + 75, r1.getY() + 35, "+");
						Text t6 = new Text(r1.getX() + 150, r1.getY() + 35, "0");
						Text t7 = new Text(r1.getX() + 200, r1.getY() + 35, "+");
						// Dien gia tri khung y
						Line line1 = new Line(r1.getX() + 75, r1.getY() + r1.getHeight() - 10,
								r1.getX() + r1.getWidth() - 35, r1.getY() + 55);
						Text t10 = new Text(r1.getX() + 150, r1.getY() + 90, str_y31);
						Text t11 = new Text(r1.getX() + 35, r1.getY() + r1.getHeight() - 10, "-oo");
						Text t12 = new Text(r1.getX() + r1.getWidth() - 35, r1.getY() + 55, "+oo");

//               		//them gioi han
//               		Text text11 = new Text(r1.getX()+85,r1.getY()+15,str_limit_min);
//          		  Text text12 = new Text(r1.getX()+220,r1.getY()+15,str_limit_max);
//          		  Text text13 = new Text(r1.getX()+85,r1.getY()+75,str_ylimit_min);
//          		  Text text14 = new Text(r1.getX()+220,r1.getY()+75,str_ylimit_max);
//               		  
						// gr.getChildren().addAll(t1,t2,t4,t5,t6,t7,line1,t10,t11,t12,text11,text12,text13,text14);
						gr.getChildren().addAll(t1, t2, t4, t5, t6, t7, line1, t10, t11, t12);
					} else {
						// Dien gia tri len khung x
						Text t1 = new Text(r1.getX() + 35, r1.getY() + 15, "-oo");
						Text t2 = new Text(r1.getX() + 150, r1.getY() + 15, x31);
						Text t4 = new Text(r1.getX() + r1.getWidth() - 35, r1.getY() + 15, "+oo");
						// Dien gia tri len khung y'
						Text t5 = new Text(r1.getX() + 75, r1.getY() + 35, "-");
						Text t6 = new Text(r1.getX() + 150, r1.getY() + 35, "0");
						Text t7 = new Text(r1.getX() + 200, r1.getY() + 35, "-");
						// Dien gia tri khung y
						Line line1 = new Line(r1.getX() + 75, r1.getY() + 55, r1.getX() + r1.getWidth() - 35,
								r1.getY() + r1.getHeight() - 10);
						Text t10 = new Text(r1.getX() + 150, r1.getY() + 90, str_y31);
						Text t11 = new Text(r1.getX() + 35, r1.getY() + 55, "+oo");
						Text t12 = new Text(r1.getX() + r1.getWidth() - 35, r1.getY() + r1.getHeight() - 10, "-oo");

//               		//them gioi han
//               		Text text11 = new Text(r1.getX()+85,r1.getY()+15,str_limit_min);
//          		  Text text12 = new Text(r1.getX()+220,r1.getY()+15,str_limit_max);
//          		  Text text13 = new Text(r1.getX()+85,r1.getY()+75,str_ylimit_min);
//          		  Text text14 = new Text(r1.getX()+220,r1.getY()+75,str_ylimit_max);

						// gr.getChildren().addAll(t1,t2,t4,t5,t6,t7,line1,t10,t11,t12,text11,text12,text13,text14);
						gr.getChildren().addAll(t1, t2, t4, t5, t6, t7, line1, t10, t11, t12);
					}
				}
			}
		}
		// endregion

		gr.getChildren().addAll(r1, l1, l2, l3, text1, text2, text3);

	}

	public void KhaoSatPTB3() {
		// TXD
		khaosat = null;
		cuctri = null;
		setTXD("Tập Xác Định: D=R");
		double delta;
		delta = 2 * _b3 * 2 * _b3 - 4 * 3 * _a3 * _c3;

		if (_a3 > 0) {
			// Gioi Han
			setGioiHan("Giới hạn: Khi x tiến đến + oo thì \n lim y = + oo"
					+ " \n  Khi x tiến đến - oo thì \n lim y = - oo");
			if (delta > 0) {

				x1 = (((-2) * _b3 + Math.sqrt(delta)) / (2 * 3 * _a3));
				x2 = (((-2) * _b3 - Math.sqrt(delta)) / (2 * 3 * _a3));
				cucdai = _a3 * x2 * x2 * x2 + _b3 * x2 * x2 + _c3 * x2 + _d3;
				cuctieu = _a3 * x1 * x1 * x1 + _b3 * x1 * x1 + _c3 * x1 + _d3;
				x1 = Math.round((x1 * 100) / 100);
				x2 = Math.round((x2 * 100) / 100);
				cucdai = Math.round((cucdai * 100) / 100);
				cuctieu = Math.round((cuctieu * 100) / 100);

				// label thong bao
				setDBNB("Hàm số đồng biến trên (-oo," + x2 + ") \n và (" + x1 + ",+oo) ; nghịch biến trên \n (" + x2
						+ "," + x1 + ")");
				set_y2Phay("* y'' = " + 6 * _a3 + " .x + " + 2 * _b3);
				xdiemuon = (-_b3) / (3 * _a3);
				ydiemuon = _a3 * xdiemuon * xdiemuon * xdiemuon + _b3 * xdiemuon * xdiemuon + _c3 * xdiemuon + _d3;
				xdiemuon = Math.round((xdiemuon * 100) / 100);
				ydiemuon = Math.round((ydiemuon * 100) / 100);
				y_min = _a3 * limit_min * limit_min * limit_min + _b3 * limit_min * limit_min + _c3 * limit_min + _d3;
				y_max = _a3 * limit_max * limit_max * limit_max + _b3 * limit_max * limit_max + _c3 * limit_max + _d3;
				if (y_max >= y_min && y_max >= cucdai) {
					GTLN = "Hàm số đạt giá trị lớn nhất \n tại điểm (" + limit_max + "," + y_max + ") trên đoạn \n ["
							+ limit_min + "," + limit_max + "]";
				} else if (y_max <= y_min && y_max >= cucdai) {
					GTLN = "Hàm số đạt giá trị lớn nhất \n tại điểm (" + limit_min + "," + y_min + ") trên đoạn \n ["
							+ limit_min + "," + limit_max + "]";
				} else if (cucdai >= y_max && cucdai >= y_min) {
					GTLN = "Hàm số đạt giá trị lớn nhất \n tại điểm (" + x2 + "," + cucdai + ") trên đoạn \n ["
							+ limit_min + "," + limit_max + "]";
				}

				if (y_max <= cuctieu && y_max <= y_min) // y_max nho nhat
				{
					GTNN = "Hàm số đạt giá trị nhỏ nhất \n tại điểm (" + limit_max + "," + y_max + ") trên đoạn \n ["
							+ limit_min + "," + limit_max + "]";
				} else if (y_min <= y_max && y_min <= cuctieu) // y_min nho nhat
				{
					GTNN = "Hàm số đạt giá trị nhỏ nhất \n tại điểm (" + limit_min + "," + y_min + ") trên đoạn \n ["
							+ limit_min + "," + limit_max + "]";
				} else if (cuctieu <= y_max && cuctieu <= y_min) // cuc tieu nho nhat
				{
					GTNN = "Hàm số đạt giá trị nhỏ nhất \n tại điểm (" + x1 + "," + cuctieu + ") trên đoạn \n ["
							+ limit_min + "," + limit_max + "]";
				}
				cuctri += "\n Hàm số đạt cực đại tại x = " + x2 + " ,yCĐ = " + cucdai;
				cuctri += "\n Hàm số đạt cực tiểu tạo x = " + x1 + " ,yCT = " + cuctieu + '\n';
				setDiemUon("Phương trình y'' = 0 có nghiệm \n x = " + xdiemuon + " => I(" + xdiemuon + "," + ydiemuon
						+ ")\n là điểm uốn của đồ thị hàm số đã cho");
				set_yPhay("Phương trình y' = " + _a3 * 3 + " .x^2 + " + _b3 * 2 + ".x + " + _c3 + " có 2 nghiệm \n"
						+ " x1=" + x1 + " và x2=" + x2);
			} else if (delta == 0) {
				y_min = _a3 * limit_min * limit_min * limit_min + _b3 * limit_min * limit_min + _c3 * limit_min + _d3;
				y_max = _a3 * limit_max * limit_max * limit_max + _b3 * limit_max * limit_max + _c3 * limit_max + _d3;
//                if(y_max >= y_min && y_max >= cucdai)
//                {
//               	 GTLN = "Hàm số đạt giá trị lớn nhất tại điểm ("+limit_max+","+y_max+") trên đoạn ["+limit_min+","+limit_max+"]";
//                }
//                else if(y_max<=y_min && y_max >=cucdai)
//                {
//               	 GTLN = "Hàm số đạt giá trị lớn nhất tại điểm ("+limit_min+","+y_min+") trên đoạn ["+limit_min+","+limit_max+"]";
//                }
//                else if(cucdai>= y_max && cucdai >= y_min)
//                {
//               	 GTLN = "Hàm số đạt giá trị lớn nhất tại điểm ("+x2+","+cucdai+") trên đoạn ["+limit_min+","+limit_max+"]";
//                }
				GTLN = "Hàm số đạt giá trị lớn nhất \n tại điểm (" + limit_max + "," + y_max + ") trên đoạn \n ["
						+ limit_min + "," + limit_max + "]";

				GTNN = "Hàm số đạt giá trị nhỏ nhất \n tại điểm (" + limit_min + "," + y_min + ") trên đoạn \n ["
						+ limit_min + "," + limit_max + "]";
				setDBNB("Phương trình y' = 0 có nghiệm kép"
						+ "\n Hàm số đồng biến trên (-oo,+oo) .Hàm số \n không có cực trị");
				set_yPhay("Phương trình y' = " + _a3 * 3 + " .x^2 + " + _b3 * 2 + ".x + " + _c3 + " có 1 nghiệm \n"
						+ " x1=" + x1);
			} else if (delta < 0) {
				y_min = _a3 * limit_min * limit_min * limit_min + _b3 * limit_min * limit_min + _c3 * limit_min + _d3;
				y_max = _a3 * limit_max * limit_max * limit_max + _b3 * limit_max * limit_max + _c3 * limit_max + _d3;
//                if(y_max >= y_min && y_max >= cucdai)
//                {
//               	 GTLN = "Hàm số đạt giá trị lớn nhất tại điểm ("+limit_max+","+y_max+") trên đoạn ["+limit_min+","+limit_max+"]";
//                }
//                else if(y_max<y_min && y_max >=cucdai)
//                {
//               	 GTLN = "Hàm số đạt giá trị lớn nhất tại điểm ("+limit_min+","+y_min+") trên đoạn ["+limit_min+","+limit_max+"]";
//                }
//                else if(cucdai>= y_max && cucdai >= y_min)
//                {
//               	 GTLN = "Hàm số đạt giá trị lớn nhất tại điểm ("+x2+","+cucdai+") trên đoạn ["+limit_min+","+limit_max+"]";
//                }
				GTLN = "Hàm số đạt giá trị lớn nhất \n tại điểm (" + limit_max + "," + y_max + ") trên đoạn \n ["
						+ limit_min + "," + limit_max + "]";

				GTNN = "Hàm số đạt giá trị nhỏ nhất \n tại điểm (" + limit_min + "," + y_min + ") trên đoạn \n ["
						+ limit_min + "," + limit_max + "]";
				setDBNB("Phương trình y' = 0 vô nghiệm "
						+ "\n Hàm số đồng biến trên (-oo,+oo) \n .Hàm số không có cực trị");
				set_yPhay("Phương trình y' = " + _a3 * 3 + " .x^2 + " + _b3 * 2 + ".x + " + _c3 + " có vô nghiệm \n");
			}
		} else if (_a3 < 0) {
			setGioiHan(
					"Giới hạn: Khi x tiến đến + oo \n thì lim y = - oo" + "\n Khi x tiến đến - oo \n thì lim y = + oo");
			if (delta > 0) {

				x1 = (((-2) * _b3 + Math.sqrt(delta)) / (2 * 3 * _a3));
				x2 = (((-2) * _b3 - Math.sqrt(delta)) / (2 * 3 * _a3));
				cuctieu = _a3 * x1 * x1 * x1 + _b3 * x1 * x1 + _c3 * x1 + _d3;
				cucdai = _a3 * x2 * x2 * x2 + _b3 * x2 * x2 + _c3 * x2 + _d3;
				x1 = Math.round((x1 * 100) / 100);
				x2 = Math.round((x2 * 100) / 100);
				cucdai = Math.round((cucdai * 100) / 100);
				cuctieu = Math.round((cuctieu * 100) / 100);

				// label thong bao
				setDBNB("Hàm số nghịch biến trên \n (-oo," + x2 + ") và (" + x1 + ",+oo) ; \n đồng biến trên (" + x2
						+ "," + x1 + ")");
				xdiemuon = (-_b3) / (3 * _a3);
				ydiemuon = _a3 * xdiemuon * xdiemuon * xdiemuon + _b3 * xdiemuon * xdiemuon + _c3 * xdiemuon + _d3;
				xdiemuon = Double.parseDouble(new DecimalFormat("#.##").format(xdiemuon));
				ydiemuon = Double.parseDouble(new DecimalFormat("#.##").format(ydiemuon));
				y_min = _a3 * limit_min * limit_min * limit_min + _b3 * limit_min * limit_min + _c3 * limit_min + _d3;
				y_max = _a3 * limit_max * limit_max * limit_max + _b3 * limit_max * limit_max + _c3 * limit_max + _d3;
				if (y_max >= y_min && y_max >= cucdai) {
					GTLN = "Hàm số đạt giá trị lớn nhất \n tại điểm (" + limit_max + "," + y_max + ") trên đoạn \n ["
							+ limit_min + "," + limit_max + "]";
				} else if (y_max <= y_min && y_max >= cucdai) {
					GTLN = "Hàm số đạt giá trị lớn nhất \n tại điểm (" + limit_min + "," + y_min + ") trên đoạn \n ["
							+ limit_min + "," + limit_max + "]";
				} else if (cucdai >= y_max && cucdai >= y_min) {
					GTLN = "Hàm số đạt giá trị lớn nhất \n tại điểm (" + x2 + "," + cucdai + ") trên đoạn \n ["
							+ limit_min + "," + limit_max + "]";
				}

				if (y_max <= cuctieu && y_max <= y_min) // y_max nho nhat
				{
					GTNN = "Hàm số đạt giá trị nhỏ nhất \n tại điểm (" + limit_max + "," + y_max + ") trên đoạn \n ["
							+ limit_min + "," + limit_max + "]";
				} else if (y_min <= y_max && y_min <= cuctieu) // y_min nho nhat
				{
					GTNN = "Hàm số đạt giá trị nhỏ nhất n tại điểm (" + limit_min + "," + y_min + ") trên đoạn \n ["
							+ limit_min + "," + limit_max + "]";
				} else if (cuctieu <= y_max && cuctieu <= y_min) // cuc tieu nho nhat
				{
					GTNN = "Hàm số đạt giá trị nhỏ nhất \n tại điểm (" + x1 + "," + cuctieu + ") trên đoạn \n ["
							+ limit_min + "," + limit_max + "]";
				}
				cuctri += "\n Hàm số đạt cực đại tại x = " + x2 + " ,yCĐ = " + cucdai;
				cuctri += "\n Hàm số đạt cực tiểu tạo x = " + x1 + " ,yCT = " + cuctieu + '\n';
				setDiemUon("Phương trình y'' = 0 có nghiệm \n x = " + xdiemuon + " => M(" + xdiemuon + "," + ydiemuon
						+ ") là điểm uốn của đồ thị hàm số đã cho");
				set_yPhay("Phương trình y' = " + _a3 * 3 + " .x^2 + " + _b3 * 2 + ".x + " + _c3 + " có 2 nghiệm \n"
						+ " x1=" + x1 + " và x2=" + x2);
			} else if (delta == 0) {
				y_min = _a3 * limit_min * limit_min * limit_min + _b3 * limit_min * limit_min + _c3 * limit_min + _d3;
				y_max = _a3 * limit_max * limit_max * limit_max + _b3 * limit_max * limit_max + _c3 * limit_max + _d3;
//                if(y_max >= y_min && y_max >= cucdai)
//                {
//               	 GTLN = "Hàm số đạt giá trị lớn nhất tại điểm ("+limit_max+","+y_max+") trên đoạn ["+limit_min+","+limit_max+"]";
//                }
//                else if(y_max<=y_min && y_max >=cucdai)
//                {
//               	 GTLN = "Hàm số đạt giá trị lớn nhất tại điểm ("+limit_min+","+y_min+") trên đoạn ["+limit_min+","+limit_max+"]";
//                }
//                else if(cucdai>= y_max && cucdai >= y_min)
//                {
//               	 GTLN = "Hàm số đạt giá trị lớn nhất tại điểm ("+x2+","+cucdai+") trên đoạn ["+limit_min+","+limit_max+"]";
//                }
				GTLN = "Hàm số đạt giá trị lớn nhất \n tại điểm (" + limit_max + "," + y_max + ") trên đoạn \n ["
						+ limit_min + "," + limit_max + "]";

				GTNN = "Hàm số đạt giá trị nhỏ nhất \n tại điểm (" + limit_min + "," + y_min + ") trên đoạn \n ["
						+ limit_min + "," + limit_max + "]";
				setDBNB("Phương trình y' = 0 có nghiệm kép"
						+ "\n Hàm số nghịch biến trên (-oo,+oo) .Hàm số \n không có cực trị");
				set_yPhay("Phương trình y' = " + _a3 * 3 + " .x^2 + " + _b3 * 2 + ".x + " + _c3 + " có 1 nghiệm \n"
						+ " x1=" + x1);
			} else if (delta < 0) {
				y_min = _a3 * limit_min * limit_min * limit_min + _b3 * limit_min * limit_min + _c3 * limit_min + _d3;
				y_max = _a3 * limit_max * limit_max * limit_max + _b3 * limit_max * limit_max + _c3 * limit_max + _d3;
//                if(y_max >= y_min && y_max >= cucdai)
//                {
//               	 GTLN = "Hàm số đạt giá trị lớn nhất tại điểm ("+limit_max+","+y_max+") trên đoạn ["+limit_min+","+limit_max+"]";
//                }
//                else if(y_max<=y_min && y_max >=cucdai)
//                {
//               	 GTLN = "Hàm số đạt giá trị lớn nhất tại điểm ("+limit_min+","+y_min+") trên đoạn ["+limit_min+","+limit_max+"]";
//                }
//                else if(cucdai>= y_max && cucdai >= y_min)
//                {
//               	 GTLN = "Hàm số đạt giá trị lớn nhất tại điểm ("+x2+","+cucdai+") trên đoạn ["+limit_min+","+limit_max+"]";
//                }
				GTLN = "Hàm số đạt giá trị lớn nhất \n tại điểm (" + limit_max + "," + y_max + ") trên đoạn \n ["
						+ limit_min + "," + limit_max + "]";

				GTNN = "Hàm số đạt giá trị nhỏ nhất \n tại điểm (" + limit_min + "," + y_min + ") trên đoạn \n ["
						+ limit_min + "," + limit_max + "]";
				setDBNB("Phương trình y' = 0 vô nghiệm"
						+ "\n Hàm số nghịch biến trên (-oo,+oo) .Hàm số không \n có cực trị");
				set_yPhay("Phương trình y' = " + _a3 * 3 + " .x^2 + " + _b3 * 2 + ".x + " + _c3 + " có vô nghiệm \n");
			}
		}
		set_yPhay("* y' = " + _a3 * 3 + " .x^2 + " + _b3 * 2 + ".x + " + _c3);
		khaosat = "TXĐ :" + getTXD() + '\n' + "Giới hạn :" + getGioiHan() + '\n' + get_yPhay() + '\n' + getDBNB();
		khaosat += "\n Phương trình y'' = " + 6 * _a3 + " .x + " + 2 * _b3 + " = 0  có nghiệm \n x = " + xdiemuon
				+ " => I(" + xdiemuon + "," + ydiemuon + ")\n là điểm uốn của đồ thị hàm số đã cho \n";
		khaosat += "Cực trị: \n" + getCuctri();
		khaosat += "\n GTLN :" + getGTLN();
		khaosat += "\n GTNN :" + getGTNN();
	}

	public String get_yPhay() {
		return _yPhay;
	}

	public void set_yPhay(String _yPhay) {
		this._yPhay = _yPhay;
	}

	public String get_y2Phay() {
		return _y2Phay;
	}

	public void set_y2Phay(String _y2Phay) {
		this._y2Phay = _y2Phay;
	}

	public String getTXD() {
		return TXD;
	}

	public void setTXD(String tXD) {
		TXD = tXD;
	}

	public String getGioiHan() {
		return GioiHan;
	}

	public void setGioiHan(String gioiHan) {
		GioiHan = gioiHan;
	}

	public String getDBNB() {
		return DBNB;
	}

	public void setDBNB(String dBNB) {
		DBNB = dBNB;
	}

	public String getDiemUon() {
		return DiemUon;
	}

	public void setDiemUon(String diemUon) {
		DiemUon = diemUon;
	}

	public double getY_min() {
		return y_min;
	}

	public void setY_min(double y_min) {
		this.y_min = y_min;
	}

	public double getY_max() {
		return y_max;
	}

	public void setY_max(double y_max) {
		this.y_max = y_max;
	}

	public String getCuctri() {
		return cuctri;
	}

	public void setCuctri(String cuctri) {
		this.cuctri = cuctri;
	}
}
