package KhaoSat;

import java.text.DecimalFormat;

import javax.sound.sampled.LineListener;
import javax.swing.JOptionPane;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class PTTrungPhuong {
	private double _a4, _b4, _c4;// biáº¿n cá»§a Ä‘á»“ thá»‹ báº­c 3

	private String _yPhay, _y2Phay;
	private String TXD, GioiHan, DBNB, DiemUon;
	private int limit_min, limit_max;
	private double y_min, y_max;
	private String GTLN, GTNN;

	public String khaosat;
	private String cuctri;

	private double d, x1, x2,x3, cucdai, cuctieu, xdiemuon, ydiemuon;

	public String getGTLN() {
		return GTLN;
	}

	public void setGTLN(String gTLN) {
		GTLN = gTLN;
	}

	public double get_a4() {
		return _a4;
	}

	public void set_a4(double _a4) {
		this._a4 = _a4;
	}

	public double get_b4() {
		return _b4;
	}

	public void set_b4(double _b4) {
		this._b4 = _b4;
	}

	public double get_c4() {
		return _c4;
	}

	public void set_c4(double _c4) {
		this._c4 = _c4;
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

	public String getKhaosat() {
		return khaosat;
	}

	public void setKhaosat(String khaosat) {
		this.khaosat = khaosat;
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

	public void NhapPT4(Double a4, Double b4, Double c4, int lim_min, int lim_max) {
		try {
			this._a4 = a4;
			this._b4 = b4;
			this._c4 = c4;
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
		
		Line l1 = new Line(0,20,400,20);
		Line l2 = new Line(0,40,400,40);
		Line l3 = new Line(50,0,50,140);
		
		Text t1 = new Text(25,10,"x");
		Text t2 = new Text(25,30,"y'");
		Text t3 = new Text(25,90,"y");
		Text t4 = new Text(75,10,"-oo");
		Text t5 = new Text(225,10,"0");
		Text t6 = new Text(375,10,"+oo");
		Text t7 = new Text(225,30,"0");
		
		x2 =0;
		
		x1 = ((-1)*_b4)/(2*_a4)>0 ? (-1)*Math.sqrt(((-1)*_b4)/(2*_a4)) : 0;
		x3 =((-1)*_b4)/(2*_a4)>0 ? Math.sqrt(((-1)*_b4)/(2*_a4)) : 0;
		
		String x41 = dcf.format(x1);
		String x42 = dcf.format(x2);
		String x43 = dcf.format(x3);
		
		double y41 = _a4*Math.pow(x1, 4)+_b4*Math.pow(x1, 2)+_c4;
		double y42 = _c4;
		double y43 = _a4*Math.pow(x3, 4)+_b4*Math.pow(x3, 2)+_c4;
		
		y41 = Math.round((y41 * 100) / 100);
		y42 = Math.round((y42 * 100) / 100);
		y43 = Math.round((y43 * 100) / 100);
		
		String str_y41 = dcf.format(y41);
		String str_y42 = dcf.format(y42);
		String str_y43 = dcf.format(y43);
		
		if(_a4>0) {
			if(_b4 <0) {
				//dien gia tri x len x
				Text str_x1 = new Text(150,10,x41);
				Text str_x2 = new Text(300,10,x43);
				//Dien y'
				Text t8 = new Text(100,30,"-");
				Text t9 = new Text(150,30,"0");
				Text t10 = new Text(180,30,"+");
				Text t11 = new Text(260,30,"-");
				Text t12 = new Text(300,30,"0");
				Text t13 = new Text(335,30,"+");
				//Dien y
				Text t14 = new Text(75,50,"+oo");
				Line l4 = new Line(80,60,145,110);
				Text t15 = new Text(150,120,str_y41);
				Line l5 = new Line(155,110,220,60);
				Text t16 = new Text(225,50,str_y42);
				Line l6 = new Line(230,60,295,110);
				Text t17 = new Text(300,120,str_y43);
				Line l7 = new Line(305,110,370,60);
				Text t18 = new Text(375,50,"+oo");
				gr.getChildren().addAll(str_x1,str_x2,t8,t9,t10,t11,t12,t13,t14,l4,t15,l5,t16,l6,t17,l7,t18);
				
			}else {
				//Dien y'
				Text t8 = new Text(110,30,"-");
				Text t9 = new Text(300,30,"+");
				//Dien y
				Text t10 = new Text(75,50,"+oo");
				Line l4 = new Line(80,60,220,110);
				Text t11 = new Text(225,120,str_y42);
				Line l5 = new Line(230,110,370,60);
				Text t12 = new Text(375,50,"+oo");
				gr.getChildren().addAll(t8,t9,t10,l4,t11,l5,t12);
			}

		}else if(_a4<0){
			if (_b4 >0) {
				Text str_x1 = new Text(150,10,x41);
				Text str_x2 = new Text(300,10,x43);
				//Dien y'
				Text t8 = new Text(100,30,"+");
				Text t9 = new Text(150,30,"0");
				Text t10 = new Text(180,30,"-");
				Text t11 = new Text(260,30,"+");
				Text t12 = new Text(300,30,"0");
				Text t13 = new Text(335,30,"-");
				//Dien y
				Text t14 = new Text(75,120,"-oo");
				Line l4 = new Line(80,110,145,60);
				Text t15 = new Text(150,50,str_y41);
				Line l5 = new Line(155,60,220,110);
				Text t16 = new Text(225,120,str_y42);
				Line l6 = new Line(230,110,295,60);
				Text t17 = new Text(300,50,str_y43);
				Line l7 = new Line(305,60,370,110);
				Text t18 = new Text(375,120,"-oo");
				gr.getChildren().addAll(str_x1,str_x2,t8,t9,t10,t11,t12,t13,t14,l4,t15,l5,t16,l6,t17,l7,t18);
			}else {
				Text t8 = new Text(110,30,"+");
				Text t9 = new Text(300,30,"-");
				//Dien y
				Text t10 = new Text(75,120,"-oo");
				Line l4 = new Line(80,110,220,60);
				Text t11 = new Text(225,50,str_y42);
				Line l5 = new Line(230,60,370,110);
				Text t12 = new Text(375,120,"-oo");
				gr.getChildren().addAll(t8,t9,t10,l4,t11,l5,t12);
			}
		}
		gr.getChildren().addAll(r1,t1,t2,t3,t4,t5,t6,t7,l1,l2,l3);
	}
	public void KhaoSatPTTrungPhuong() {
		DecimalFormat dcf = new DecimalFormat("#.##");
		khaosat = null;
		cuctri = "";
		setTXD("Tập Xác Định: D=R");
		if (_a4 > 0) {
			setGioiHan("Giới hạn: Khi x tiến đến + oo thì \n lim y = + oo"
					+ " \n  Khi x tiến đến - oo thì \n lim y = + oo");
			if (_b4 <0) {
				x2 =0;		
				x1 = ((-1)*_b4)/(2*_a4)>0 ? (-1)*Math.sqrt(((-1)*_b4)/(2*_a4)) : 0;
				x3 =((-1)*_b4)/(2*_a4)>0 ? Math.sqrt(((-1)*_b4)/(2*_a4)) : 0;
				
				cucdai = _c4;
				cuctieu = _a4*Math.pow(x1, 4) + _b4*Math.pow(x1, 2) + _c4;
				
				x1 = Math.round((x1 * 100) / 100);
				x2 = 0;
				x3 = Math.round((x3 * 100) / 100);
				
				cucdai = Math.round((cucdai * 100) / 100);
				cuctieu = Math.round((cuctieu * 100) / 100);
				// label thong bao
				set_yPhay("y'="+4*_a4+"x^3 + "+2*_b4+"x \n y'=0 => x1="+x1+" ; x2="+x2+" ; x3="+x3+"");
				setDBNB("Hàm số đồng biến trên ("+x1+"," + x2 + ") và (" + x3 + ",+oo)\nHàm số nghịch biến trên (-oo," + x1 + ") và ("+x2+","+x3+")");
				setCucdai(cucdai);
				setCuctieu(cuctieu);
				cuctri += "Hàm số đạt giá trị lớn nhất tại x="+x2+", \ngiá trị lớn nhất GTLN ="+cucdai+"";
				cuctri+= "\nHàm số đạt giá trị nhỏ nhất tại x="+x1+" và x="+x3+", \ngiá trị nhỏ nhất GTNN ="+cuctieu+"";
				set_y2Phay("y''="+12*_a4+"x^2 +"+2*_b4+"");
				double i1 = (-1)*Math.sqrt((-1)*_b4/(6*_a4));
				double i2 = Math.sqrt((-1)*_b4/(6*_a4));
				double y1 = _a4*Math.pow(i1, 4) + _b4*Math.pow(i1,2) + _c4;
				double y2 = _a4*Math.pow(i2, 4) + _b4*Math.pow(i2,2) + _c4;
				
				
				String i41 = dcf.format(i1);
				String i42 =dcf.format(i2);
				String y41 = dcf.format(y1);
				String y42 = dcf.format(y2);
				setDiemUon("Điểm uốn: \nI("+i41+","+y41+") và J("+i42+","+y42+")");
				setCuctri(cuctri);
				
			}else {
				cuctieu = _c4;
				set_yPhay("y'="+4*_a4+"x^3 + "+2*_b4+"x \n y'=0 => x2="+x2+"");
				setDBNB("Hàm số đồng biến trên và (" + x2 + ",+oo)\nHàm số nghịch biến trên (-oo," + x2 + ")");
				setCuctieu(cuctieu);
				cuctri+="\nHàm số đạt giá trị nhỏ nhất tại x= "+x2+", giá trị nhỏ nhất GTNN= "+cuctieu+"";
				set_y2Phay("y''="+12*_a4+"x^2 +"+2*_b4+"");
				setDiemUon("\nHàm số không có điểm uốn");
				setCuctri(cuctri);
			}		
		}else if(_a4 <0) {
			setGioiHan("Giới hạn: Khi x tiến đến + oo thì \n lim y = - oo"
					+ " \n  Khi x tiến đến - oo thì \n lim y = - oo");
			if(_b4 >0) {
				x2 =0;		
				x1 = ((-1)*_b4)/(2*_a4)>0 ? (-1)*Math.sqrt(((-1)*_b4)/(2*_a4)) : 0;
				x3 =((-1)*_b4)/(2*_a4)>0 ? Math.sqrt(((-1)*_b4)/(2*_a4)) : 0;
				
				cuctieu = _c4;
				cucdai = _a4*Math.pow(x1, 4) + _b4*Math.pow(x1, 2) + _c4;
				
				x1 = Math.round((x1 * 100) / 100);
				x2 = 0;
				x3 = Math.round((x3 * 100) / 100);
				
				cucdai = Math.round((cucdai * 100) / 100);
				cuctieu = Math.round((cuctieu * 100) / 100);
				// label thong bao
				set_yPhay("y'="+4*_a4+"x^3 + "+2*_b4+"x \n y'=0 => x1="+x1+" ; x2="+x2+" ; x3="+x3+"");
				setDBNB("Hàm số nghịch biến trên ("+x1+"," + x2 + ") và (" + x3 + ",+oo)\nHàm số đồng biến trên (-oo," + x1 + ") và ("+x2+","+x3+")");
				setCucdai(cucdai);
				setCuctieu(cuctieu);
				
				cuctri+= "Hàm số đạt giá trị lớn nhất tại x="+x1+" và x="+x3+" \n	giá trị lớn nhất GTLN ="+cucdai+"";
				cuctri += "\nHàm số đạt giá trị nhỏ nhất tại x="+x2+",\n	giá trị nhỏ nhất GTNN ="+cuctieu+"";
				setCuctri(cuctri);
				set_y2Phay("y''="+12*_a4+"x^2 +"+2*_b4+"");
				double i1 = (-1)*Math.sqrt((-1)*_b4/(6*_a4));
				double i2 = Math.sqrt((-1)*_b4/(6*_a4));
				double y1 = _a4*Math.pow(i1, 4) + _b4*Math.pow(i1,2) + _c4;
				double y2 = _a4*Math.pow(i2, 4) + _b4*Math.pow(i2,2) + _c4;
				String i41 = dcf.format(i1);
				String i42 =dcf.format(i2);
				String y41 = dcf.format(y1);
				String y42 = dcf.format(y2);
				setDiemUon("Điểm uốn: \nI("+i41+","+y41+") và J("+i42+","+y42+")");
				setCuctri(cuctri);
			}else {
				cucdai = _c4;
				set_yPhay("y'="+4*_a4+"x^3 + "+2*_b4+"x \n y'=0 => x2="+x2+"");
				setDBNB("Hàm số nghịch biến trên và (" + x2 + ",+oo)\nHàm số đồng biến trên (-oo," + x2 + ")");
				setCucdai(cucdai);
				cuctri+="\nHàm số đạt giá trị lớn nhất tại x= "+x2+", giá trị lớn nhất GTLN= "+cucdai+"";
				set_y2Phay("y''="+12*_a4+"x^2 +"+2*_b4+"");
				setDiemUon("\nHàm số không có điểm uốn");
				setCuctri(cuctri);
			}
		}
		khaosat = "TXĐ :" + getTXD() + '\n' + "Giới hạn :" + getGioiHan() + '\n' + get_yPhay() + '\n' + getDBNB();
		khaosat += "\n"+getDiemUon();
		khaosat += "Cực trị: \n" + getCuctri();
//		khaosat += "\n GTLN :" + getGTLN();
//		khaosat += "\n GTNN :" + getGTNN();
	}

	public double getX3() {
		return x3;
	}

	public void setX3(double x3) {
		this.x3 = x3;
	}

	public String getCuctri() {
		return cuctri;
	}

	public void setCuctri(String cuctri) {
		this.cuctri = cuctri;
	}

}
