/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testintegermatrix;

/**
 *
 * @author shelm
 */
public class RationalMatrix extends GenericMatrix<Rational>{
    @Override
    protected Rational add(Rational r1, Rational r2) {
        return r1.add(r2);
    }
    
    @Override
    protected Rational multiply(Rational r1, Rational r2) {
        return r1.multiply(r2);
    }
    
    @Override 
    protected Rational zero() {
	return new Rational(0, 1);
    }
}
