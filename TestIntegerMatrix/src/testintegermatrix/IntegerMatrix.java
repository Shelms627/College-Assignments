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
public class IntegerMatrix extends GenericMatrix<Integer>{
    @Override
    protected Integer add(Integer o1, Integer o2) {
	return o1 + o2;
    }
    
    @Override
    protected Integer multiply(Integer o1, Integer o2) {
	return o1 * o2;
    }
    
    @Override
    protected Integer zero() {
        return 0;
    }
}
