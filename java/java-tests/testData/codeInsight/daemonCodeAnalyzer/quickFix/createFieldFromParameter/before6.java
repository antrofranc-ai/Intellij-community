// "Create field for parameter 'p1'" "true-preview"

class Test{
    int myP1;
    int myP2;
 
    void f(int p<caret>1, int p2){
        int myP2 = p1;
        p1 = 0;
    }
}

