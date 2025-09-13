class FooBar {
    std:: mutex m;
    std:: condition_variable cv;
    int turn;
private:
    int n;

public:
    FooBar(int n) {
        this->n = n;
        this->turn=0;
    }

    void foo(function<void()> printFoo) {
        std::unique_lock<std::mutex> lock(m);
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo() outputs "foo". Do not change or remove this line.
            while(turn!=0){
                cv.wait(lock);
            }
        	printFoo();
            turn = 1;
            cv.notify_all();
        }
    }

    void bar(function<void()> printBar) {
        std::unique_lock<std::mutex> lock(m);
        for (int i = 0; i < n; i++) {
            
        	// printBar() outputs "bar". Do not change or remove this line.
            while(turn!=1){
                cv.wait(lock);
            }
        	printBar();
            turn=0;
            cv.notify_all();
        }
    }
};