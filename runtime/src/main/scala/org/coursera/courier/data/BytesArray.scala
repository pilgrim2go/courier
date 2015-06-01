

/*
 Copyright 2015 Coursera Inc.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package org.coursera.courier.data

import javax.annotation.Generated

import com.linkedin.data.ByteString
import com.linkedin.data.DataList
import com.linkedin.data.schema.ArrayDataSchema
import com.linkedin.data.schema.DataSchema
import com.linkedin.data.template.DataTemplate
import com.linkedin.data.template.DataTemplateUtil
import org.coursera.courier.data.DataTemplates.DataConversion

import scala.collection.GenTraversable
import scala.collection.JavaConverters._
import scala.collection.generic.CanBuildFrom
import scala.collection.mutable


@Generated(value = Array("BytesArray"), comments="Courier Data Template.", date = "Sat May 30 12:21:42 PDT 2015")
final class BytesArray(private val dataList: DataList)
  extends IndexedSeq[ByteString]
  with Product
  with GenTraversable[ByteString]
  with DataTemplate[DataList] {

  override def length: Int = dataList.size()


  private[this] def lookup(idx: Int) = {

        dataList.get(idx).asInstanceOf[com.linkedin.data.ByteString]


  }

  override def apply(idx: Int): ByteString = lookup(idx)

  override def productElement(n: Int): Any = dataList.get(n)
  override def productArity: Int = dataList.size()

  override def schema(): DataSchema = BytesArray.SCHEMA

  override def data(): DataList = dataList
  override def copy(): DataTemplate[DataList] = this
}

object BytesArray {
  val SCHEMA = DataTemplateUtil.parseSchema("""{"type":"array","items":"bytes"}""").asInstanceOf[ArrayDataSchema]

  val empty = BytesArray()

  def apply(elems: ByteString*): BytesArray = {
    new BytesArray(new DataList(elems.map(coerceOutput).toList.asJava))
  }

  def apply(collection: Traversable[ByteString]): BytesArray = {
    new BytesArray(new DataList(collection.map(coerceOutput).toList.asJava))
  }

  def apply(dataList: DataList, conversion: DataConversion) : BytesArray = {
    new BytesArray(DataTemplates.makeImmutable(dataList, SCHEMA, conversion))
  }

  def newBuilder = new DataBuilder()

  implicit val canBuildFrom = new CanBuildFrom[BytesArray, ByteString, BytesArray] {
    def apply(from: BytesArray) = new DataBuilder(from)
    def apply() = newBuilder
  }

  class DataBuilder(initial: BytesArray) extends mutable.Builder[ByteString, BytesArray] {
    def this() = this(new BytesArray(new DataList()))

    val elems = new DataList(initial.data())

    def +=(x: ByteString): this.type = {
      elems.add(coerceOutput(x))
      this
    }

    def clear() = {
      elems.clear()
    }

    def result() = {
      elems.setReadOnly()
      new BytesArray(elems)
    }
  }

  private def coerceOutput(value: ByteString): AnyRef = {

        value

  }
}

