package exercise;

// BEGIN
public class ListThread extends Thread{

    private SafetyList safetyList;

    public ListThread(SafetyList safetyList) {
        this.safetyList = safetyList;
    }

    @Override
    public void run() {

        for( var i = 0; i <= 1000; i++) {

            try {
                ListThread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            safetyList.add(i);
        }
    }
}
// END
