package aquarium.repositories;

import aquarium.entities.decorations.Decoration;

import java.util.Collection;


public class DecorationRepository implements Repository {
    private Collection<Decoration> decorations;

    @Override
    public void add(Decoration decoration) {
        decorations.add(decoration);
    }

    @Override
    public boolean remove(Decoration decoration) {
        return decorations.remove(decoration);
    }

    @Override
    public Decoration findByType(String type) {
        return decorations.stream()
                .filter(d -> d.getClass().getSimpleName().equals(type))
                .findFirst()
                .orElse(null);
    }
}
