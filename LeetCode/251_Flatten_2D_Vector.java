/**
 * Type: Two Pointers
 * Time: worst case m * n, average 1
 * Space: 1
 */

public class Vector2D implements Iterator<Integer> {
    int i, j;
    List<List<Integer>> list;

    public Vector2D(List<List<Integer>> vec2d) {
        list = vec2d;
        i = 0;
        j = 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        return list.get(i).get(j++);
    }

    @Override
    public boolean hasNext() {
        while (i != list.size() && j >= list.get(i).size()) {
            i++;
            j = 0;
        }
        if (i == list.size()) {
            return false;
        }
        return j < list.get(i).size();
    }
}

/**
 * Type: Iterator
 * Time: worst case m * n, average 1
 * Space: 1
 */

public class Vector2D implements Iterator<Integer> {
  private Iterator<List<Integer>> rowIter;
  private Iterator<Integer> colIter;
  
  public Vector2D(List<List<Integer>> vec2d) {
      this.rowIter = vec2d.iterator();
      this.colIter = Collections.emptyIterator();
  }

  @Override
  public Integer next() {
      return colIter.next();
  }

  @Override
  public boolean hasNext() {
      while ((colIter == null || !colIter.hasNext()) && rowIter.hasNext()) {
          colIter = rowIter.next().iterator();
      }
      return colIter != null && colIter.hasNext();
  }
}

/**
* Your Vector2D object will be instantiated and called as such:
* Vector2D i = new Vector2D(vec2d);
* while (i.hasNext()) v[f()] = i.next();
*/