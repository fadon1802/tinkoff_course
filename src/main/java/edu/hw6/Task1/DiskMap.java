package edu.hw6.Task1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DiskMap implements Map<String, String> {
    private final Path path;
    private final HashMap<String, String> map = new HashMap<>();

    public DiskMap(String path) throws IOException {
        this.path = Path.of(path);
        if (!Files.isWritable(this.path)) {
            Files.createFile(this.path);
        }
    }

    @SuppressWarnings({"MagicNumber"})
    public void loadFromDisk() throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(48);
        var fileChannel = FileChannel.open(path, StandardOpenOption.CREATE);
        int bytesRead = fileChannel.read(buffer);
        var sb = new StringBuilder();

        while (bytesRead != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                sb.append((char) buffer.get());
            }

            buffer.clear();
            bytesRead = fileChannel.read(buffer);
        }

        fileChannel.close();
        var content = sb.toString();
        var lines = content.split("\n");
        map.clear();
        for (var line : lines) {
            var keyValue = line.split(": ");
            if (keyValue.length != 1) {
                map.put(keyValue[0], keyValue[1]);
            }
        }
    }

    private void saveToDisk() throws IOException {
        StringBuilder str = new StringBuilder();
        for (var entry: map.entrySet()) {
            str.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        Files.writeString(path, str);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public String get(Object key) {
        return map.get(key);
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        var temp = map.put(key, value);
        try {
            saveToDisk();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return temp;
    }

    @Override
    public String remove(Object key) {
        var temp = map.remove(key);
        try {
            saveToDisk();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return temp;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        map.putAll(m);
        try {
            saveToDisk();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void clear() {
        map.clear();
        try {
            saveToDisk();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        return map.keySet();
    }

    @NotNull
    @Override
    public Collection<String> values() {
        return map.values();
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        return map.entrySet();
    }
}
