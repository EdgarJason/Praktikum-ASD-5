public class DLL<T> {
    Node<T> head, tail;
    int size = 0;

    //inisialisasi
    void inisialisasi() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //is empty
    boolean isEmpty() {
        return (size == 0);
    }

    //size
    int size() {
        return size;
    }

    //penambahan
    void addFirst(T input) {
        Node<T> newNode = new Node<>(input);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    void addLast(T input) {
        Node<T> newNode = new Node<>(input);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    //penyisipan atau penambahan
    void insertAt(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Indeks tidak valid: " + index);
        }
        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            Node<T> newNode = new Node<>(data);
            Node<T> before = current.prev;

            before.next = newNode;
            newNode.prev = before;
            newNode.next = current;
            current.prev = newNode;
            size++;
        }
    }

    //penghapusan
    void removeFirst() {
        if (isEmpty()) {
            System.out.println("List kosong! Tidak ada yang bisa dihapus.");
        } else {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            size--;
            System.out.println("Data paling pertama berhasil dihapus!");
        }
    }

    void removeLast() {
        if (isEmpty()) {
            System.out.println("List kosong! Tidak ada yang bisa dihapus.");
        } else {
            if (head == tail) {
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            size--;
            System.out.println("Data terakhir berhasil dihapus!");
        }
    }

    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Indeks: " + index + ", Ukuran: " + size);
        }

        if (index == 0) {
            removeFirst();
            return;
        }

        if (index == size - 1) {
            removeLast();
            return;
        }

        Node<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        T data = current.data;

        current.prev.next = current.next;
        current.next.prev = current.prev;

        size--;

        System.out.println("Data '" + data + "' pada indeks " + index + " telah dihapus.");
    }

    //pencarian
    String find(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return "Data: " + data + " ditemukan";
            }
            current = current.next;
        }
        return "Data: " + data + " tidak ditemukan!";
    }

    //pengaksesan
    T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Indeks tidak valid: " + index);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    //pencetakan
    public void printList() {
        if (isEmpty()) {
            System.out.println("List: [ Kosong ]");
            return;
        }
        System.out.print("List: [ ");
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + (current.next != null ? " <-> " : ""));
            current = current.next;
        }
        System.out.println(" ], Ukuran: " + size());
    }

    //untuk kelas MAHASISWA
    public void addSorted(T data) {
        if (!(data instanceof Mahasiswa)) {
            System.out.println("Data yang dimasukkan harus berupa objek Mahasiswa.");
            return;
        }

        Mahasiswa mhsInput = (Mahasiswa) data;
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            head = tail = newNode;
            size++;
            return;
        }

        if (mhsInput.getIpk() >= ((Mahasiswa) head.data).getIpk()) {
            addFirst(data);
            return;
        }

        if (mhsInput.getIpk() <= ((Mahasiswa) tail.data).getIpk()) {
            addLast(data);
            return;
        }

        Node<T> current = head;
        while (mhsInput.getIpk() < ((Mahasiswa) current.data).getIpk()) {
            current = current.next;
        }

        Node<T> before = current.prev;
        before.next = newNode;
        newNode.prev = before;
        newNode.next = current;
        current.prev = newNode;
        size++;
    }

    public void displayDESC() {
        System.out.println("--------------------------------------");
        System.out.println("Data Mahasiswa (Urutan IPK Descending)");
        System.out.println("--------------------------------------");

        if (isEmpty()) {
            System.out.println("List masih kosong.");
            return;
        }

        Node<T> current = head;
        int urutan = 1;
        while (current != null) {
            Mahasiswa mhs = (Mahasiswa) current.data;
            System.out.println(urutan + ". " + mhs.toString());
            current = current.next;
            urutan++;
        }
        System.out.println();
    }

    public void displayASC() {
        System.out.println("------------------------------------");
        System.out.println("Data Mahasiswa (Urutan IPK Ascending)");
        System.out.println("------------------------------------");

        if (isEmpty()) {
            System.out.println("List masih kosong.");
            return;
        }

        Node<T> current = tail;
        int urutan = 1;
        while (current != null) {
            Mahasiswa mhs = (Mahasiswa) current.data;
            System.out.println(urutan + ". " + mhs.toString());
            current = current.prev;
            urutan++;
        }
        System.out.println();
    }

}
