package src;

public class Ball {
    public static int bounceBall(double h, double bounce, double window) {
        // TODO: your code here
        int count = 0;
        if(h<=0 || bounce <= 0 || bounce>=1 ||h<=window)//조건에 부합하면 -1을 return
            return -1;

        if(window<h){//위에서 아래로 내려갈때 window를 거치면
            count++;//지나간 횟수로 count ++
            double hnew= h*bounce ;
            if(window<hnew){//튀어오른 높이가 window를 거치면
                count++;//count++
                count += bounceBall(hnew, bounce, window);//재귀적으로 함수 호출, count에 추가
            }
        }
        return count;
    }
}