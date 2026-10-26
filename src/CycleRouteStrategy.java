public class CycleRouteStrategy implements RouteStrategy {
    @Override
    public String buildRoute(String origin, String destination) {
        return "Cycling route from " + origin + " to " + destination
                + " via bike lanes (balanced speed and safety).";
    }
}