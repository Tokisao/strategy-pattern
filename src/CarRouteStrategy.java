public class CarRouteStrategy implements RouteStrategy {
    @Override
    public String buildRoute(String origin, String destination) {
        return "Car route from " + origin + " to " + destination
                + " via highways (fastest, tolls may apply).";
    }
}