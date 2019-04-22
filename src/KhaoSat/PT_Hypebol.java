package KhaoSat;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class PT_Hypebol {
	private double _a1, _b1, _c1, _d1;
	private String _yPhay, _y2Phay;
	private String TXD, GioiHan, DBNB;
	private int limit_min, limit_max;
	private double y_min, y_max;
	private String GTLN, GTNN;

	public String khaosat;
	private String cuctri;
	private String TiemCanDung, TiemCanNgang;

	public PT_Hypebol() {
	}

	public String getTiemCanDung() {
		return TiemCanDung;
	}

	public void setTiemCanDung(String tiemCanDung) {
		TiemCanDung = tiemCanDung;
	}

	public String getTiemCanNgang() {
		return TiemCanNgang;
	}

	public void setTiemCanNgang(String tiemCanNgang) {
		TiemCanNgang = tiemCanNgang;
	}

	public double get_a1() {
		return _a1;
	}

	public void set_a1(double _a1) {
		this._a1 = _a1;
	}

	public double get_b1() {
		return _b1;
	}

	public void set_b1(double _b1) {
		this._b1 = _b1;
	}

	public double get_c1() {
		return _c1;
	}

	public void set_c1(double _c1) {
		this._c1 = _c1;
	}

	public double get_d1() {
		return _d1;
	}

	public void set_d1(double _d1) {
		this._d1 = _d1;
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

	public String getCuctri() {
		return cuctri;
	}

	public void setCuctri(String cuctri) {
		this.cuctri = cuctri;
	}

	public double getD() {
		return d;
	}

	public void setD(double d) {
		this.d = d;
	}

	public double getTsyphay() {
		return tsyphay;
	}

	public void setTsyphay(double tsyphay) {
		this.tsyphay = tsyphay;
	}

	private double d, tsyphay;

	public void NhapPT_Hypebol(double a1, double b1, double c1, double d1, int limitmin, int limitmax) {
		try {
			this._a1 = a1;
			this._b1 = b1;
			this._c1 = c1;
			this._d1 = d1;
			this.limit_min = limitmin;
			this.limit_max = limitmax;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Loi nhap phuong trinh bac 1 / bac 1");
		}
	}

	public void KhaoSatPT_Hypebol() {
		// TXD
		khaosat = null;
		cuctri = null;
		setTXD("Tập Xác Định: D = (-oo, + " + -_d1 / _c1 + ") và (" + -_d1 / _c1 + ", +oo )");
		tsyphay = _a1 * _d1 - _b1 * _c1;
		this.d = _a1 * _d1 - _b1 * _c1;

		if (d > 0) {
			setGioiHan("Giới hạn: Khi  x  tiến  đến  " + -_d1 / _c1
					+ "\n thì  lim y = oo. Khi  x  tiến  đến oo\n  thì  lim y = " + _a1 / _c1 + ")");
			setTiemCanDung("Đường thẳng x = " + -_d1 / _c1 + " là\n tiệm cận đứng của đồ thị hàm số");
			setTiemCanNgang("Đường thẳng y = " + _a1 / _c1 + " là\n tiệm cận ngang của đồ thị hàm số");
			setDBNB("y' > 0 với mọi x # " + -_d1 / _c1 + ") \n. Hàm số đồng biến trên (-oo," + -_d1 / _c1 + ") và\n ("
					+ -_d1 / _c1 + ",+oo)");
			setCuctri("Nhận xét: Hàm số đã cho không có cực trị.");
		} else if (d < 0) {
			setGioiHan("Giới hạn: Khi  x  tiến  đến  " + -_d1 / _c1
					+ "\n thì  lim y = oo. Khi  x  tiến  đến oo\n  thì  lim y = " + _a1 / _c1 + ")");
			setTiemCanDung("Đường thẳng x = " + -_d1 / _c1 + " là\n tiệm cận đứng của đồ thị hàm số");
			setTiemCanNgang("Đường thẳng y = " + _a1 / _c1 + " là\n tiệm cận ngang của đồ thị hàm số");
			setDBNB("y' < 0 với mọi x # " + -_d1 / _c1 + ") \n. Hàm số đồng biến trên (-oo," + -_d1 / _c1 + ") và\n ("
					+ -_d1 / _c1 + ",+oo)");
			setCuctri("Nhận xét: Hàm số đã cho không có cực trị.");
		}
		set_yPhay("* y' = " + tsyphay + "/[(" + _c1 + ".x + " + _d1 + ")^2]");
		khaosat = "TXĐ :" + getTXD() + '\n' + "Giới hạn :" + getGioiHan() + '\n' + get_yPhay() + '\n' + getDBNB()
				+ '\n';
		khaosat += "Cực trị: \n" + getCuctri();

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
		// Tinh gia tri m = a/c, p = ad- bc, n= -d/c
		double m = _a1 / _c1;
		double n = -_d1 / _c1;
		double p = (_a1 * _d1) - (_b1 * _c1);
		String stringm = dcf.format(m);
		String stringn = dcf.format(n);
		//String stringp = dcf.format(p);

		if (p > 0) 	{
			// viet gia tri len khung x
			Text t1 = new Text(r1.getX() + 35, r1.getY() + 15, "-oo");
			Text t2 = new Text(r1.getX() + 195, r1.getY() + 15, stringn);
			Text t3 = new Text(r1.getX() + r1.getWidth() - 35, r1.getY() + 15, "+oo");
			// Dien gia tri len khung y'
			Text t4 = new Text(r1.getX() + 150, r1.getY() + 35, "+");
			Text t5 = new Text(r1.getX() + 250, r1.getY() + 35, "+");
			// viet gia tri len khung y
			Text t6 = new Text(r1.getX() + 35, r1.getY() + r1.getHeight() - 20, "-oo");
			Line line1 = new Line(r1.getX() + 75, r1.getY() + r1.getHeight() - 10, r1.getX() + 175, r1.getY() + 55);
			Text t7 = new Text(r1.getX() + 175, r1.getY() + 55, stringm);
			Line line2 = new Line(r1.getX() + 200, r1.getY() + 55, r1.getX() + 200, r1.getY() + r1.getHeight() - 10);
			Line line3 = new Line(r1.getX() + 202, r1.getY() + 55, r1.getX() + 202, r1.getY() + r1.getHeight() - 10);
			Text t8 = new Text(r1.getX() + 205, r1.getY() + r1.getHeight() - 20, stringm);
			Line line4 = new Line(r1.getX() + 210, r1.getY() + r1.getHeight() - 10, r1.getX() + r1.getWidth() - 35,r1.getY() + 55);
			Text t9 = new Text(r1.getX() + r1.getWidth() - 35, r1.getY() + 55, "-oo");

			gr.getChildren().addAll(t1, t2, t3, t4, t5, t6, t7, t8, t9, line1, line2, line3, line4);

		} else {
			// viet gia tri len khung x
			Text t1 = new Text(r1.getX() + 35, r1.getY() + 15, "-oo");
			Text t2 = new Text(r1.getX() + 195, r1.getY() + 15, stringn);
			Text t3 = new Text(r1.getX() + r1.getWidth() - 35, r1.getY() + 15, "+oo");
			// Dien gia tri len khung y'
			Text t4 = new Text(r1.getX() + 150, r1.getY() + 35, "-");
			Text t5 = new Text(r1.getX() + 250, r1.getY() + 35, "-");
			// viet gia tri len khung y
			Text t6 = new Text(r1.getX() + 35, r1.getY() + 55, "+oo");
			Line line1 = new Line(r1.getX() + 75, r1.getY() + 55, r1.getX() + 175, r1.getY() + r1.getHeight() - 10);
			Text t7 = new Text(r1.getX() + 175, r1.getY() + r1.getHeight() - 10, stringm);
			Line line2 = new Line(r1.getX() + 200, r1.getY() + 55, r1.getX() + 200, r1.getY() + r1.getHeight() - 10);
			Line line3 = new Line(r1.getX() + 202, r1.getY() + 55, r1.getX() + 202, r1.getY() + r1.getHeight() - 10);
			Text t8 = new Text(r1.getX() + 205, r1.getY() + 55, stringm);
			Line line4 = new Line(r1.getX() + 210, r1.getY() + 55, r1.getX() + r1.getWidth() - 35,r1.getY() + r1.getHeight() - 10);
			Text t9 = new Text(r1.getX() + r1.getWidth() - 35, r1.getY() +  r1.getHeight() - 10, "+oo");
			gr.getChildren().addAll(t1, t2, t3, t4, t5, t6, t7, t8, t9, line1, line2, line3, line4);
		}
		
		// endregion
		gr.getChildren().addAll(r1, l1, l2, l3, text1, text2, text3);
	}
}
