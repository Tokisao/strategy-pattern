public class Navigator {
    private RouteStrategy strategy;

    public Navigator(RouteStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(RouteStrategy strategy) {
        this.strategy = strategy;
    }

    public String planRoute(String origin, String destination) {
        return strategy.buildRoute(origin, destination);
    }
}