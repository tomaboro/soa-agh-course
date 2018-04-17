package com.motek.soa;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class TempConverter
 */
@Stateless
@LocalBean
public class TempConverter implements TempConverterRemote {


	public double Fahr2Cels(double fahr) {
		double celcs = (5/9*(fahr-32));
		return celcs;
	}

	public double Cels2Fahr(double cels) {
		double fahr = (9/5)*cels+32;
		return fahr;
	}

}
