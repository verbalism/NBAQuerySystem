package businesslogic;

import java.util.List;

public class LinearRegression {

	protected List<Double> xList;
	protected List<Double> yList;  
    
	public LinearRegression(List<Double> xList ,List<Double> yList){  
      this.xList = xList;  
      this.yList = yList;  
	}  

	public double getB(){
		int n = 0;
		double sumx = 0.0, sumy = 0.0, sumx2 = 0.0;
		while (n< xList.size()) {
			sumx += xList.get(n);
			sumx2 += xList.get(n) * xList.get(n);
			sumy += yList.get(n);
			n++;
		}
		double xbar = sumx / n;
		double ybar = sumy / n;
		double xxbar = 0.0, yybar = 0.0, xybar = 0.0;

		for (int i = 0; i < n; i++) {
			xxbar += (xList.get(i) - xbar) * (xList.get(i) - xbar);
			yybar += (yList.get(i) - ybar) * (yList.get(i) - ybar);
			xybar += (xList.get(i) - xbar) * (yList.get(i) - ybar);
		}

		double beta1 = xybar / xxbar;

		double beta0 = ybar - beta1*xbar;
		return beta1;
		}
}

