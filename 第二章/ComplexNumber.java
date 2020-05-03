public class ComplexNumber {
    private double imaginaryPart;
    private double realPart;
    public ComplexNumber() {
    	super();
    }
    public ComplexNumber(double imaginaryPart,double realPart) {
    	boolean isRight= (realPart>0)&&(imaginaryPart>0);
    	assert isRight:"参数添加错误，你不能添加负数";
    	this.imaginaryPart=imaginaryPart;
    	this.realPart =realPart;
    }
    //used to add two number
    public ComplexNumber add(ComplexNumber a,ComplexNumber b) {
    	double r,i;
    	r=a.realPart+b.realPart;
    	i=a.imaginaryPart+b.imaginaryPart;
        return new ComplexNumber(r,i);
    }
    //used to get Angle of a ComplexNumber
    public double getAngle() {
    	return Math.atan(getImaginaryPart()/getRealPart());
    }
    //used to get imaginary part
    public double getImaginaryPart() {
    	return imaginaryPart;
    }
    //used to get realPart
    public double getRealPart() {
    	return realPart;
    }
    //used to get magnitude of a ComplexNumber 
    public double getMagnitude() {
    	return Math.sqrt(imaginaryPart*imaginaryPart+realPart*realPart);
    }
    
    //use override toString to get a+bi
	@Override
	public String toString() {
		return realPart+"+"+imaginaryPart+"i";
	}
  
	/**1.9*/
	@Override
	public boolean equals(Object obj) {
		if(obj==this) {
			return true;
		}
		if(obj==null) {
			return false;
		}
		else if(!(obj instanceof ComplexNumber)) {
			return false;
		}
		else {
		    ComplexNumber a=(ComplexNumber)obj;
		    return a.realPart==this.realPart&&a.imaginaryPart==this.imaginaryPart;//优化写法
//		    if(this.realPart==a.realPart&&this.imaginaryPart==a.imaginaryPart) {
//		    	return true;
//		    }
//		    else {
//		    	return false;
//		    }
		}
	    
	}
	public static void main(String[] args) {
		ComplexNumber a=new ComplexNumber(3,4);
		System.out.println(a.getMagnitude());
		System.out.println(a.getAngle());
		
	}

}
