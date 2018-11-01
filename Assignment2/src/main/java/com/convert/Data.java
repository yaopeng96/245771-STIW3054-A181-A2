package com.convert;

import java.io.FileOutputStream;

import com.itextpdf.text.pdf.PdfWriter;

public class Data { 
	private String no,name,fidelID,fED,rtg,clubncity;
	
	public Data() {
		super();
	}
	
	public Data(String no,String name, String fidelID, String fED, String rtg, String clubncity) {
		this.no = no;
		this.name = name;
		this.fidelID = fidelID;
		this.fED = fED;
		this.rtg = rtg;
		this.clubncity = clubncity;
	}
	
	public String getNo(){
        return no;
    }

    public void setNo(String no){
        this.no = no;
    }
    
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public String getfidelID(){
        return fidelID;
    }

    public void setfidelID(String fidelID){
        this.fidelID = fidelID;
    }
    
    public String getfED(){
        return fED;
    }

    public void setfED(String fED){
        this.fED = fED;
    }
    
    public String getRtg(){
        return rtg;
    }

    public void setRtg(String rtg){
        this.rtg= rtg;
    }
    
    public String getClubnCity(){
        return clubncity;
    }

    public void setClubnCity(String clubncity){
        this.clubncity= clubncity;
    }
}


