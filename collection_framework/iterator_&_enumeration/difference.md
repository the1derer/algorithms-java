  ----------------------------------------------------
  Diff. b/w Enumeration and Iterator
  
  Enumeration                                                                          |    Iterator
  - - - - - - - - - - -- -  - - - - - - -                                              - - - - - - -- -- -  - - - - - -
  1. Legacy interface which doesn't come under collecn framework.                      | Part of collecn framework
  
  2. All the legacy classes like legacy Stack, Vector can use Enumeration.             | Classes under colln Framework like ArrayList, LinkedList
  
  3. Enumeration in average performs about 50% faster than iterator for                |  While Iterator is in process, there are checks where th
      sequential access of the Collection elements.                                                                                 |  elements are under going concurrent updating. This is
                                                                                       |  the reason for slowness.
  
  4. Enumeration doesn't have remove() method                                          | Has remove() method
  
  5. Enumeration is not fail fast                                                      | Is fail fast.