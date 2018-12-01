package uk.co.gluedit.asjson

// The "serialise to JSON" behaviour is encoded in this trait
trait JsonWriter[A] {
  def write(value: A): Json
}
