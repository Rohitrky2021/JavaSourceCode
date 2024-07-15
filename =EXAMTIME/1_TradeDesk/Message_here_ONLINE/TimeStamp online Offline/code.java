import java.util.*;

class U {
    int i;
    boolean a;
}

class C {
    Map<Integer, U> u = new HashMap<>();
    Map<Integer, Integer> m = new HashMap<>();

    void p(List<List<String>> e) {
        for (List<String> ev : e) {
            String a = ev.get(0);
            int t = 0;
            try {
                t = Integer.parseInt(ev.get(1));
            } catch (NumberFormatException ex) {
                System.err.println("Invalid timestamp: " + ev.get(1));
                continue;
            }

            if ("MESSAGE".equals(a)) {
                String ml = ev.get(2);
                Scanner iss = new Scanner(ml);
                while (iss.hasNext()) {
                    String tk = iss.next();
                    if ("ALL".equals(tk)) {
                        for (Map.Entry<Integer, U> us : u.entrySet()) {
                            m.merge(us.getKey(), 1, Integer::sum);
                        }
                    } else if ("HERE".equals(tk)) {
                        for (Map.Entry<Integer, U> us : u.entrySet()) {
                            if (us.getValue().a) {
                                m.merge(us.getKey(), 1, Integer::sum);
                            }
                        }
                    } else if (tk.length() >= 3) {
                        try {
                            int id = Integer.parseInt(tk.substring(2));
                            m.merge(id, 1, Integer::sum);
                        } catch (NumberFormatException ex) {
                            System.err.println("Invalid user ID: " + tk.substring(2));
                        }
                    }
                }
            } else if ("OFFLINE".equals(a) && ev.size() >= 3) {
                String idStr = ev.get(2).substring(2);
                if (!idStr.isEmpty()) {
                    try {
                        int id = Integer.parseInt(idStr);
                        if (u.containsKey(id)) {
                            u.get(id).a = false;
                            m.merge(id, -1, Integer::sum);
                            m.merge(-1, -1, Integer::sum);
                            if (u.get(id).a) {
                                m.merge(-2, -1, Integer::sum);
                            }
                        }
                    } catch (NumberFormatException ex) {
                        System.err.println("Invalid user ID: " + idStr);
                    }
                }
            }
        }
    }

    List<String> g() {
        List<String> r = new ArrayList<>();
        for (Map.Entry<Integer, Integer> me : m.entrySet()) {
            if (me.getKey() >= 0) {
                r.add("id" + me.getKey() + " - " + me.getValue());
            }
        }
        r.sort(Comparator.naturalOrder());
        return r;
    }
}

public class code {
    public static void main(String[] args) {
        List<List<String>> e = List.of(
                List.of("MESSAGE", "0", "ALL id158 id42"),
                List.of("OFFLINE", "1", "id158"),
                List.of("MESSAGE", "2", "id158 id158"),
                List.of("OFFLINE", "3", "id23"),
                List.of("MESSAGE", "60", "HERE id158 id42 id23"),
                List.of("MESSAGE", "61", "HERE")
        );

        C c = new C();
        c.p(e);
        List<String> r = c.g();
        for (String s : r) {
            System.out.println(s);
        }
    }
}
