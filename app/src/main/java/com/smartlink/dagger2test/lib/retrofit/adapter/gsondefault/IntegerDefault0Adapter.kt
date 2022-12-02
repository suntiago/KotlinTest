package com.smartlink.dagger2test.lib.retrofit.adapter.gsondefault

import com.google.gson.JsonSerializer
import com.google.gson.JsonDeserializer
import com.google.gson.JsonParseException
import com.google.gson.JsonElement
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonSyntaxException
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonPrimitive
import java.lang.Exception
import java.lang.NumberFormatException
import java.lang.reflect.Type

/**
 * Created by Allen on 2017/11/20.
 *
 *
 * 定义为int类型,如果后台返回""或者null,则返回0
 */
class IntegerDefault0Adapter : JsonSerializer<Int?>, JsonDeserializer<Int> {
    @Throws(JsonParseException::class)
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): Int {
        try {
            if (json.asString == "" || json.asString == "null") {
                return 0
            }
        } catch (ignore: Exception) {
        }
        return try {
            json.asInt
        } catch (e: NumberFormatException) {
            throw JsonSyntaxException(e)
        }
    }

    override fun serialize(
        src: Int?,
        typeOfSrc: Type,
        context: JsonSerializationContext
    ): JsonElement {
        return JsonPrimitive(src)
    }
}