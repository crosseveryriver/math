/**
 * Created by Administrator on 2017/11/12.
 */
public class Matrix {
    double [][] data;

    public Matrix(double[][] data){
        if(data.length == 0 || data[0] == null || data[0].length ==0)
            throw new RuntimeException("Illegal Matrix data format");
        this.data = data;
    }

    public Matrix getL(){
        double[][] result = new double[this.getRowNumber()][this.getColumnNumber()];
        for (int i = 0; i < this.getRowNumber(); i++) {
            for (int j = 0; j < i; j++) {
                result[i][j] = this.dataAt(i,j);
            }
        }
        return new Matrix(result);
    }

    public Matrix getR(){
        double[][] result = new double[this.getRowNumber()][this.getColumnNumber()];
        for (int i = 0; i < this.getRowNumber(); i++) {
            for (int j = i + 1; j < this.getColumnNumber(); j++) {
                result[i][j] = this.dataAt(i,j);
            }
        }
        return new Matrix(result);
    }

    public double getInfiniteForm(){
        double max = Math.abs(this.dataAt(0,0));
        for (int i = 0; i < this.getRowNumber(); i++) {
            max = Math.max(Math.abs(this.dataAt(i,0)),max);
        }
        return max;
    }

    public Matrix minus(Matrix matrix){
        return this.add(matrix.numberMultiply(-1));
    }

    public Matrix add(Matrix matrix){
        if(this.getRowNumber() != matrix.getRowNumber() ||
                this.getColumnNumber() != matrix.getColumnNumber()){
            throw new RuntimeException("add matrix error : matrixes don't match");
        }
        double[][] result = new double[this.getRowNumber()][this.getColumnNumber()];
        for (int i = 0; i < this.getRowNumber(); i++) {
            for (int j = 0; j < this.getColumnNumber(); j++) {
                result[i][j] = this.dataAt(i,j) + matrix.dataAt(i,j);
            }
        }
        return new Matrix(result);

    }

    public Matrix inverseMatrix(){
        return new Matrix(this.getReverseMartrix(data));
    }

    public boolean isSquareMatrix(){
        return this.getColumnNumber() == this.getRowNumber();
    }

    public Matrix getDet(){
        if (!this.isSquareMatrix())
            throw new RuntimeException("not a valid square matrix");
        double[][] result = new double[this.getRowNumber()][this.getColumnNumber()];
        for (int i = 0; i < this.getRowNumber(); i++) {
            result[i][i] = data[i][i];
        }
        return new Matrix(result);
    }
    

    //数乘
    public Matrix numberMultiply(double factor){
        double[][] result = new double[this.getRowNumber()][this.getColumnNumber()];
        for (int i = 0; i < this.getRowNumber() ; i++) {
            for (int j = 0; j < this.getColumnNumber(); j++) {
                result[i][j] = data[i][j] * factor;
            }
        }
        return new Matrix(result);
    }

    //矩阵乘法
    public Matrix multiply(Matrix matrix){
        if(this.getColumnNumber() != matrix.getRowNumber())
            throw new RuntimeException("matrixs can't multiply");
        int m = this.getRowNumber();
        int n = matrix.getColumnNumber();
        double[][] result = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = 0;
                for (int k = 0; k < this.getColumnNumber(); k++) {
                    result[i][j] += this.dataAt(i,k) * matrix.dataAt(k,j);
                }
            }
        }
        return new Matrix(result);
    }

    public int getColumnNumber(){
        return data[0].length;
    }

    public int getRowNumber(){
        return data.length;
    }

    public double dataAt(int row, int col){
        return data[row][col];
    }

    @Override
    public String toString() {
        String result = "";
        for(double[] row : data){
            for(double number : row){
                result += number;
                result += "\t";
            }
            result += "\r\n";
        }
        return result;
    }


    /*
     * 求(h,v)坐标的位置的余子式
     */
    private double[][] getConfactor(double[][] data, int h, int v) {
        int H = data.length;
        int V = data[0].length;
        double[][] newdata = new double[H-1][V-1];
        for(int i=0; i<newdata.length; i++) {
            if(i < h-1) {
                for(int j=0; j<newdata[i].length; j++) {
                    if(j < v-1) {
                        newdata[i][j] = data[i][j];
                    }else {
                        newdata[i][j] = data[i][j+1];
                    }
                }
            }else {
                for(int j=0; j<newdata[i].length; j++) {
                    if(j < v-1) {
                        newdata[i][j] = data[i+1][j];
                    }else {
                        newdata[i][j] = data[i+1][j+1];
                    }
                }
            }
        }
        return newdata;
    }

    /*
  * 计算行列式的值
  */
    public double getMartrixResult(double[][] data) {
        /*
         * 二维矩阵计算
         */
        if(data.length == 2) {
            return data[0][0]*data[1][1] - data[0][1]*data[1][0];
        }
        /*
         * 二维以上的矩阵计算
         */
        double result = 0;
        int num = data.length;
        double[] nums = new double[num];
        for(int i=0; i<data.length; i++) {
            if(i%2 == 0) {
                nums[i] = data[0][i] * getMartrixResult(getConfactor(data, 1, i+1));
            }else {
                nums[i] = -data[0][i] * getMartrixResult(getConfactor(data, 1, i+1));
            }
        }
        for(int i=0; i<data.length; i++) {
            result += nums[i];
        }

        return result;
    }

    private double[][] getReverseMartrix(double[][] data) {
        double[][] newdata = new double[data.length][data[0].length];
        double A = getMartrixResult(data);
//      System.out.println(A);
        for(int i=0; i<data.length; i++) {
            for(int j=0; j<data[0].length; j++) {
                if((i+j)%2 == 0) {
                    newdata[i][j] = getMartrixResult(getConfactor(data, i+1, j+1)) / A;
                }else {
                    newdata[i][j] = -getMartrixResult(getConfactor(data, i+1, j+1)) / A;
                }

            }
        }
        newdata = trans(newdata);

        return newdata;
    }

    private double[][] trans(double[][] newdata) {
        // TODO Auto-generated method stub
        double[][] newdata2 = new double[newdata[0].length][newdata.length];
        for(int i=0; i<newdata.length; i++)
            for(int j=0; j<newdata[0].length; j++) {
                newdata2[j][i] = newdata[i][j];
            }
        return newdata2;
    }

}
