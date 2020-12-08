package com.nehal.ifsccode.model

import com.google.gson.annotations.SerializedName

data class IfscResponse(
	@SerializedName("DISTRICT")
	val dISTRICT: String?,
	@SerializedName("CONTACT")
	val cONTACT: String?,
	@SerializedName("IMPS")
	val iMPS: Boolean?,
	@SerializedName("MICR")
	val mICR: String?,
	@SerializedName("STATE")
	val sTATE: String?,
	@SerializedName("BRANCH")
	val bRANCH: String?,
	@SerializedName("NEFT")
	val nEFT: Boolean?,
	@SerializedName("CITY")
	val cITY: String?,
	@SerializedName("RTGS")
	val rTGS: Boolean?,
	@SerializedName("UPI")
	val uPI: Boolean?,
	@SerializedName("ADDRESS")
	val aDDRESS: String?,
	@SerializedName("CENTRE")
	val cENTRE: String?,
	@SerializedName("BANK")
	val bANK: String?,
	@SerializedName("BANKCODE")
	val bANKCODE: String?,
	@SerializedName("IFSC")
	val iFSC: String?
)