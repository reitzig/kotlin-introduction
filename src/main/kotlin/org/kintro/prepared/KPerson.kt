package org.kintro.prepared

/*
 * For reference: (mostly) equivalent to JPerson.
 *
 * Differences: no null values; better equals() and hashCode().
 */

data class KPerson(var name: String, var age: Int, var isFemale: Boolean)