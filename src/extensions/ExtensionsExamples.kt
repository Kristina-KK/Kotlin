package extensions

data class Person (
    val id: Int,
    val ime: String,
    val prezime: String,
    val addresses: List<Address> = ArrayList<Address>(),
    val phoneNumbers: List<PhoneNumber> = ArrayList<PhoneNumber>()
)
data class Address (val id: Int, val personId: Int, val ulica: String, val grad:String)
data class PhoneNumber (val grad: String? = null, val phoneNumber: String)

data class PersonDto(
    val imeDto: String,
    val prezimeDto: String,
    val listaGradovaDto: List<String>? = null,
    val listaAddressDto: List<AddressDto>? = null,
    val listaAddressAndPhoneNumberDto: List<AddressAndPhoneNumberDto>? = null
    )

data class AddressDto(val ulicaDto: String, val gradDto: String)

data class AddressAndPhoneNumberDto(val ulicaDto: String, val gradDto: String, val phoneNumberDto: String? = null)   // podaci iz 2 različita objekta - Address i PhoneNumber

fun main(args: Array<String>) {

    val address1 = Address(1, 1, "Zagreb 1", "Zagreb")
    val address2 = Address(2, 1, "Karlovac 1", "Karlovac")
    val address3 = Address(3, 1, "Senj 1", "Senj")

    val addressList = ArrayList<Address>()
    addressList.add(address1)
    addressList.add(address2)
    addressList.add(address3)

    val phoneNumber1 = PhoneNumber("Zagreb", "01")
    val phoneNumber2 = PhoneNumber("Karlovac", "02")
    val phoneNumber3 = PhoneNumber("Senj", "03")

    val phoneNumberList = ArrayList<PhoneNumber>()
    phoneNumberList.add(phoneNumber1)
    phoneNumberList.add(phoneNumber2)
    phoneNumberList.add(phoneNumber3)

    val person = Person(1, "Kristina", "KK", addressList, phoneNumberList)

//    val personDtoWithoutAddress = person.toDtoWithoutAddress()
//    println(personDtoWithoutAddress)
//
//    val personDto = person.toDto()
//    println(personDto)

    val personDtoWithPhone = person.linkedObjects()
    println(personDtoWithPhone)

}

// EKSTENZIJE FUNKCIJE
/*
Person - onaj tip objekta koji se proslijeđuje definiranoj funkciji npr toDto()
toDto() - naziv funkcije koja će se pozivati
=       - dodijeljeno ono što će se vratiti pozivom funkcije - return tip je opcionalan (: PersonDto)
 */
fun Person.toDtoWithoutAddress() = PersonDto (
    imeDto = ime,
    prezimeDto = prezime
    // liste su opcionalne jer im je postavljena defaultna vrijednost u primary konstruktoru
)

fun Person.toDto() : PersonDto = PersonDto (
    imeDto = ime,
    prezimeDto = prezime,
    listaGradovaDto = addresses.map{it.grad}
)

fun Person.toDtoWithAddressObject() = PersonDto (
    imeDto = ime,
    prezimeDto = prezime,
    listaAddressDto = addresses.map { AddressDto(ulicaDto = it.ulica, gradDto = it.grad) }
)

// ekstenzija funkcije u kojoj su dva linkana objekta - Address i PhoneNumber
fun Person.linkedObjects() = PersonDto (
    imeDto = ime,
    prezimeDto = prezime,
    listaAddressAndPhoneNumberDto = getAddressAndPhoneNumberDto(addresses, phoneNumbers)
)

fun getAddressAndPhoneNumberDto(listAddr: List<Address>, listPhone: List<PhoneNumber>) : List<AddressAndPhoneNumberDto> {
    val listaReturn = ArrayList<AddressAndPhoneNumberDto>()
    listAddr.forEach{ x ->
        val addrAndPhone = AddressAndPhoneNumberDto(
            ulicaDto = x.ulica,
            gradDto =  x.grad,
            phoneNumberDto = listPhone.filter { it.grad.equals(x.grad) }.single().phoneNumber
        )
        listaReturn.add(addrAndPhone)
    }
    return listaReturn
}




