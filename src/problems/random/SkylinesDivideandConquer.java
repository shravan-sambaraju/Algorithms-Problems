package problems.random;

/* Print skyline */

class SkylinesDivideandConquer {

    private static Skyline GetSkyline(Building[] buildings, int start, int end) {
        if (start == end) {
            SkylinesDivideandConquer sky = new SkylinesDivideandConquer();
            Skyline skl = sky.new Skyline(2);
            skl.Append(sky.new strip(buildings[start].left, buildings[start].h));
            skl.Append(sky.new strip(buildings[start].right, 0));
            return skl;
        }
        int mid = (start + end) / 2;
        Skyline sk1 = GetSkyline(buildings, start, mid);
        Skyline sk2 = GetSkyline(buildings, mid + 1, end);
        return MergeSkylines(sk1, sk2);
    }

    private static Skyline MergeSkylines(Skyline SK1, Skyline SK2) {
        SkylinesDivideandConquer sky = new SkylinesDivideandConquer();
        Skyline newSkl = sky.new Skyline(SK1.Count + SK2.Count);

        int currentHeight1 = 0;
        int currentHeight2 = 0;
        while ((SK1.Count > 0) && (SK2.Count > 0)) {
            if (SK1.Head().left < SK2.Head().left) {
                int CurX = SK1.Head().left;
                currentHeight1 = SK1.Head().h;
                int MaxH = currentHeight1;
                if (currentHeight2 > MaxH) {
                    MaxH = currentHeight2;
                }
                newSkl.Append(sky.new strip(CurX, MaxH));
                SK1.RemoveHead();
            } else {
                int CurX = SK2.Head().left;
                currentHeight2 = SK2.Head().h;
                int MaxH = currentHeight1;
                if (currentHeight2 > MaxH) {
                    MaxH = currentHeight2;
                }
                newSkl.Append(sky.new strip(CurX, MaxH));
                SK2.RemoveHead();
            }
        }
        while (SK1.Count > 0) {
            strip str = SK1.RemoveHead();
            newSkl.Append(str);
        }
        while (SK2.Count > 0) {
            strip str = SK2.RemoveHead();
            newSkl.Append(str);
        }
        return newSkl;
    }

    private class Building {
        int left, right, h;

        public Building(int x1, int h1, int x2) {
            left = x1;
            h = h1;
            right = x2;
        }
    }

    private class strip {
        int left, h;

        public strip(int x1, int h1) {
            left = x1;
            h = h1;
        }
    }

    private class Skyline {
        public int Count;
        strip[] strips;
        int StartLoc;

        public Skyline(int n) {
            Count = 0;
            StartLoc = 0;
            strips = new strip[n];
        }

        private void Append(strip str) {
            strips[StartLoc + Count] = str;
            Count++;
        }

        private strip Head() {
            return strips[StartLoc];
        }

        private strip RemoveHead() {
            strip str = strips[StartLoc];
            Count--;
            StartLoc++;
            return str;
        }

        public String ToString() {
            String str = "";
            for (int i = StartLoc; i < StartLoc + Count; i++) {
                if (i > StartLoc) {
                    str = str + ",";
                }
                str = str + strips[i].left + "," + strips[i].h;
            }
            return "(" + str + ")";
        }
    }
}
