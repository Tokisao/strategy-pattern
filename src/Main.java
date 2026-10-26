public class Main {
    public static void main(String[] args) {
        Navigator navigator = new Navigator(new CarRouteStrategy());
        System.out.println(navigator.planRoute("Dormitory", "Campus"));

        navigator.setStrategy(new WalkRouteStrategy());
        System.out.println(navigator.planRoute("Dormitory", "Campus"));

        navigator.setStrategy(new CycleRouteStrategy());
        System.out.println(navigator.planRoute("Dormitory", "Campus"));
    }
}