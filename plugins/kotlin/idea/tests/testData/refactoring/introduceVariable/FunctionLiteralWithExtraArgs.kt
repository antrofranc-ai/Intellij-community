// WITH_STDLIB
fun foo(c : Collection<String>){
  c.filterTo(ArrayList<String>())<selection>{ it.length > 1 }</selection>
}