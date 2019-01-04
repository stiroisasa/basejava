/**
 * Array based storage for Resumes
 */
public class  ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int i = 0;
        while (storage[i] != null) {
            storage[i] = null;
            i++;
        }
    }

    void save(Resume r) {
        storage[size()] = r;
    }

    Resume get(String uuid) {
        int i = 0;
        while (storage[i] != null) {
            if (uuid.equals(storage[i].uuid))
                return storage[i];
            i++;
        }
        return null;
    }

    void delete(String uuid) {
        int i = 0;
        while (storage[i] != null) {
            if (uuid.equals(storage[i].uuid)) {
                break;
            }
            i++;
        }
        int size = size();
        for (int j = i; j < size - 1; j++) {
            storage[j] = storage[j+1];
        }
        storage[size - 1] = null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[size()];
        System.arraycopy(storage,0,resumes,0,size());
        return resumes;
    }

    int size() {
        int count = 0;
        while (storage[count] != null) {
            count++;
        }
        return count;
    }
}
