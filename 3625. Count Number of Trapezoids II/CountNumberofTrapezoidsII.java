class Solution {
    public int countTrapezoids(int[][] points) {
      int n = points.length;
      int count = 0;

      for(int a = 0; a < n; a++){
        for(int b = a + 1; b < n; b++){
            for(int c = b + 1; c < n; c++){
                for(int d = c + 1; d < n; d++){
                    int[][] quad = {
                        points[a], points[b], points[c], points[d]
                    };
                    if(formsTrapezoids(quad)) count++;
                }
            }
        }
      }  
      return count;
    }

    private boolean formsTrapezoids(int[][] quad){
        int[][] p = orderConvex(quad);
        if(p == null) return false;

        return parallel(p[0], p[1], p[2], p[3]) || parallel(p[1], p[2], p[3], p[0]);
    }

    private boolean parallel(int[] a, int[] b, int[] c, int[] d){
        long x1 = b[0] - a[0], y1 = b[1] - a[1];
        long x2 = d[0] - c[0], y2 = d[1] - c[1];

        return x1 * y2 == y1 * x2;
    }

    private int[][] orderConvex(int[][] pts){
        double cx = 0, cy = 0;
        for(int[] p : pts){
            cx += p[0];
            cy += p[1];
        }
        cx /= 4.0; 
        cy /= 4.0;

        final double fcx = cx;
        final double fcy = cy;

        Arrays.sort(pts, (p1, p2) -> {
            double a1 = Math.atan2(p1[1] - fcy, p1[0] - fcx);
            double a2 = Math.atan2(p2[1] - fcy, p2[0] - fcx);
            return Double.compare(a1, a2);
        });

        return isConvex(pts) ? pts : null;
    }

    private boolean isConvex(int[][] p){
        int n = 4;
        long prev = 0;

        for(int i = 0; i < n; i++){
            long x1 = p[(i+1) % n][0] - p[i][0];
            long y1 = p[(i+1) % n][1] - p[i][1];
            long x2 = p[(i+2) % n][0] - p[(i+1) % n][0];
            long y2 = p[(i+2) % n][1] - p[(i+1) % n][1];

            long cross = x1 * y2 - y1 * x2; 

            if(cross != 0){
                if(prev != 0 && Long.signum(prev) != Long.signum(cross))
                    return false;
                prev = cross;
            }
        }
        return true;
    }
}
