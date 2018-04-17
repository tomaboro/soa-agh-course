package com.motek.soa;

import javax.ejb.Remote;

@Remote
public interface TempConverterRemote {
	public double Fahr2Cels(double fahr);
	public double Cels2Fahr(double cels);
}
