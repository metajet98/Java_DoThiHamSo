package KhaoSat;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
public class PT_TrungPhuong {
	private double _a4, _b4, _c4;
	private String _yPhay, _y2Phay;
	private String TXD, GioiHan, DBNB;
	private int limit_min, limit_max;
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
	private double y_min, y_max;
	private String GTLN, GTNN;

	public String khaosat;
	private String cuctri;

	public PT_TrungPhuong() {
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
	public void NhapPT_TrungPhuong(double a4, double b4, double c4, int limitmin, int limitmax) {
		try {
			this._a4 =a4 ;
			this._b4 = b4;
			this._c4 = c4;
			this.limit_min = limitmin;
			this.limit_max = limitmax;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Loi nhap phuong trinh bac 1 / bac 1");
		}
	}
	public void VeBangBienThien(Group gr) {
		
	}
	public void KhaoSatPT_TrungPhuong() {
		
	}
}
