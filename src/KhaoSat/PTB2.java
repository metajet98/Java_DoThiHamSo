package KhaoSat;

import java.security.acl.Group;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class PTB2 {
	private double _a2,_b2,_c2;
	
    private String TXD,GioiHan,DBNB,DiemUon;
    private int limit_min,limit_max;
    private double y_min,y_max;
    private String GTLN,GTNN;

    public String khaosat;
    private double d,x1, x2, xdiemuon, ydiemuon;
	public double getD() {
		return d;
	}
	public void setD(double d) {
		this.d = d;
	}
	public double getX1() {
		return x1;
	}
	public void setX1(double x1) {
		this.x1 = x1;
	}
	public double getX2() {
		return x2;
	}
	public void setX2(double x2) {
		this.x2 = x2;
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
	public double get_a2() {
		return _a2;
	}
	public void set_a2(double _a2) {
		this._a2 = _a2;
	}
	public double get_b2() {
		return _b2;
	}
	public void set_b2(double _b2) {
		this._b2 = _b2;
	}
	public double get_c2() {
		return _c2;
	}
	public void set_c2(double _c2) {
		this._c2 = _c2;
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
	public String getKhaosat() {
		return khaosat;
	}
	public void setKhaosat(String khaosat) {
		this.khaosat = khaosat;
	}
	
	public void NhapPTT2(Double a2,Double b2,Double c2, int lim_min,int lim_max) {
    	try {
			this._a2 = a2;
			this._b2 = b2;
			this._c2 = c2;
			this.limit_min = lim_min;
			this.limit_max = lim_max;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Loi nhap phuong trinh bac 2");
		}
	}
	public void VeBangBienThien(javafx.scene.Group gr) {
		DecimalFormat dcf = new DecimalFormat("#.##");
		gr.getChildren().clear();
		//region VeKhung
		Rectangle r1 = new Rectangle(0,0,400,140);
		r1.setStroke(Color.BLACK);
		r1.setFill(null);
		r1.setStrokeWidth(3);
		
		Line l1 = new Line(r1.getX(),r1.getY()+50,400,r1.getY()+50);
		Line l2 = new Line(r1.getX()+50,r1.getY(),50,r1.getY()+140);
		//Line l3 = new Line(r1.getX()+20,r1.getY(),r1.getX()+20,r1.getHeight());
		
		Text text1 = new Text(r1.getX()+25, r1.getY()+25, "x");
		Text text2 = new Text(r1.getX()+25, r1.getY()+100, "y");
		//Text text3 = new Text(r1.getX()+5, r1.getY()+55, "y");	
		
		//region VietGiaTri
		double delta = _b2*_b2 - 4*_a2*_c2;
//		x1 = ((-1)*_b2+Math.pow(delta,0.5))/(2*_a2);
//		x1 = ((-1)*_b2-Math.pow(delta,0.5))/(2*_a2);
//		String x21 = dcf.format(x1);
//		String x22 = dcf.format(x2);
//		double y21 = (_a2*x1*x1 + _b2*x1 + _c2);
//		double 
		this.setXdiemuon((-1)*_b2/(2*_a2));
		this.setYdiemuon((-1)*delta/(4*_a2));
		String xI=dcf.format(this.getXdiemuon());
		String yI = dcf.format(this.getYdiemuon());
		String str_limit_min = String.valueOf(limit_min);
		String str_limit_max = String.valueOf(limit_max);
		double ylimit_min = (_a2*limit_min*limit_min + _b2*limit_min+_c2);
		double ylimit_max = (_a2*limit_max*limit_max + _b2*limit_max + _c2);
		String str_ylimit_min = String.valueOf(ylimit_min);
		String str_ylimit_max = String.valueOf(ylimit_max);
//		if(delta >=0) {
			 Text t1 = new Text(r1.getX()+100,r1.getY()+25,"-oo");
			 Text t2 = new Text(r1.getX()+225,r1.getY()+25, xI);
			 Text t3 = new Text(r1.getX()+375,r1.getY()+25,"+oo");
			 Text t7 = new Text(r1.getX()+150,r1.getY()+25,str_limit_min);
			 Text t8 = new Text(r1.getX()+300, r1.getY()+25,str_limit_max);
			if(_a2>0) {
			//Dien gia tri len x
			 //Dien gia tri len y
   		  	Text t4 = new Text(r1.getX()+100,r1.getY()+60,"+oo");
   		  	Line line1 = new Line(r1.getX()+110,r1.getY()+70,r1.getX()+200,r1.getY()+110);
   		  	Text t5 = new Text(r1.getX()+225,r1.getY()+120,yI);
   		  	Line line2 = new Line(r1.getX()+250,r1.getY()+110,r1.getX()+360,r1.getY()+70);
   		  	Text t6 = new Text(r1.getX()+375,r1.getY()+60,"+oo");
   		  	//them gioi han
   		  	Text t9 = new Text(r1.getX()+150,r1.getY()+80,str_ylimit_min);
   		  	Text t10 = new Text(r1.getX()+300,r1.getY()+80,str_ylimit_max);
   		  	gr.getChildren().addAll(t1,t2,t3,t4,line1,t5,line2,t6,t7,t8,t9,t10);
   		  	
			}else {
			
			Text t4 = new Text(r1.getX()+100,r1.getY()+130,"-oo");
			Line line1 = new Line(r1.getX()+110,r1.getY()+120,r1.getX()+200,r1.getY()+80);
			Text t5 = new Text(r1.getX()+225,r1.getY()+70,yI);
			Line line2 = new Line(r1.getX()+250,r1.getY()+70,r1.getX()+360,r1.getY()+120);
			Text t6 = new Text(r1.getX()+375,r1.getY()+130,"-oo");
   		  	Text t9 = new Text(r1.getX()+150,r1.getY()+80,str_ylimit_min);
   		  	Text t10 = new Text(r1.getX()+300,r1.getY()+80,str_ylimit_max);
   		  	gr.getChildren().addAll(t1,t2,t3,t4,line1,t5,line2,t6,t7,t8,t9,t10);
			}			 
//		}else {
//			 Text t1 = new Text(r1.getX()+100,r1.getY()+25,"-oo");
//			 Text t2 = new Text(r1.getX()+225,r1.getY()+25, xI);
//			 Text t3 = new Text(r1.getX()+375,r1.getY()+25,"+oo");
//			 Text t7 = new Text(r1.getX()+150,r1.getY()+25,str_limit_min);
//			 Text t8 = new Text(r1.getX()+300, r1.getY()+25,str_limit_max);
//			if(_a2>0) {
//				Text t4 = new Text(r1.getX()+100,r1.getY()+130,"-oo");
//				Line line1 = new Line(r1.getX()+110,r1.getY()+120, r1.getX()+360,r1.getY()+70);
//				Text t5 = new Text(r1.getX()+150,r1.getY()+100,str_ylimit_min);
//				Text t6 = new Text(r1.getX()+225,r1.getY()+120,yI);
//				Text t9 = new Text(r1.getX()+300,r1.getY()+70,str_ylimit_max);
//				Text t10 = new Text(r1.getX()+375,r1.getY()+60,"+oo");
//				gr.getChildren().addAll(t1,t2,t3,t4,line1,t5,t6,t7,t8,t9,t10);
//			}else {
//				Text t4 = new Text(r1.getX()+100,r1.getY()+60,"+oo");
//				Line line1 = new Line(r1.getX()+110,r1.getY()+70,r1.getX()+360,r1.getY()+120);
//				Text t5 = new Text(r1.getX()+150,r1.getY()+70,str_ylimit_min);
//				Text t6 = new Text(r1.getX()+225,r1.getY()+120,yI);
//				Text t9 = new Text(r1.getX()+300,r1.getY()+100,str_ylimit_max);
//				Text t10 = new Text(r1.getX()+375,r1.getY()+130,"-oo");
//				gr.getChildren().addAll(t1,t2,t3,t4,line1,t5,t6,t7,t8,t9,t10);
//			}
//		}
		gr.getChildren().addAll(r1,l1,l2,text1,text2);
	}
	public void KhaoSatPTB2() {
		//TXD
		khaosat = null;	
		setTXD("Táº­p XÃ¡c Ä�á»‹nh: D=R");
		double delta;
		delta = (_b2*_b2 - 4*_a2*_c2);
		if(_a2 >0) {
				setGioiHan("\nKhi x tiến đến + oo thì \n lim y = + oo"+" \nKhi x tiến tới - oo thì \n lim y = + oo");		
				setXdiemuon((-1)*_b2/(2*_a2));
				setYdiemuon((-1)*delta/(4*_a2));
				String GTNN = String.valueOf(getYdiemuon());
				setDBNB("Hàm số đồng biến trên khoảng ("+getXdiemuon() +"; +oo) \nHàm số nghịch biến trên khoảng (-oo;"+getXdiemuon()+") ");
				setDiemUon("\n Điểm uốn I = ("+getXdiemuon()+";"+getYdiemuon()+") \n Trục đối xứng x= "+getXdiemuon()+".");
				setGTNN("\nGiá trị lớn nhất của hàm số: " +GTNN);
				setGTLN("\nGiá trị nhỏ nhất: Không xác định");
		}else {
			setGioiHan("\nKhi x tiến đến + oo thì \n lim y = - oo"+" \nKhi x tiến đến - oo thì \n lim y = - oo");		
			setXdiemuon((-1)*_b2/(2*_a2));
			setYdiemuon((-1)*delta/(4*_a2));
			String GTLN = String.valueOf(getYdiemuon());
			setDBNB("Hàm số nghịch biến trên khoảng ("+getXdiemuon() +"; +oo) \nHàm số đồng biến trên khoảng (-oo;"+getXdiemuon()+") ");
			setDiemUon("\nĐiểm uốn I = ("+getXdiemuon()+";"+getYdiemuon()+") \nTrục đối xứng x= "+getXdiemuon()+".");
			setGTLN("\nGiá trị lớn nhất: "+GTLN);
			setGTNN("\nGiá trị nhỏ nhất: Không xác định");
		}
    	khaosat= "TXĐ :"+getTXD()+'\n' + "Giới hạn :"+ getGioiHan() +'\n'+
				getDBNB();
    	//khaosat +="\n PhÆ°Æ¡ng trÃ¬nh y'' = "+ 6 * _a3 + " .x + " + 2 * _b3+" = 0  cÃ³ nghiá»‡m \n x = " + xdiemuon + " => I(" + xdiemuon + "," + ydiemuon + ")\n lÃ  Ä‘iá»ƒm uá»‘n cá»§a Ä‘á»“ thá»‹ hÃ m sá»‘ Ä‘Ã£ cho \n";
    	khaosat += getDiemUon();
    	khaosat += getGTLN()+getGTNN();
	}

}
