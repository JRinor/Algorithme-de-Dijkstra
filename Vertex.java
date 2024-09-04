public class Vertex {
    private int id;
    private String name;
    private int x;
    private int y;
    private boolean walkable;

    public Vertex(int x, int y, int id, String name) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.name = name;
        this.walkable = true;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getxPosition() {
        return x;
    }

    public int getyPosition() {
        return y;
    }

    public boolean isWalkable() {
        return walkable;
    }

    public void setWalkable(boolean walkable) {
        this.walkable = walkable;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vertex vertex = (Vertex) obj;
        return id == vertex.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return name;
    }
}
